package diagrams.diagrams.impl;

import diagrams.diagrams.BaseDiagram;
import diagrams.entity.CodeBlock;
import diagrams.entity.LogicBlock;
import diagrams.entity.LogicType;
import diagrams.filters.impl.JavaCleaner;

import java.util.List;

public abstract class Fluxogram extends BaseDiagram {

    public static List<LogicBlock> getFluxogramFromCode(String code) {
        return getFluxogramFromCodeBlockList(JavaCleaner.baseJavaFilter(code));
    }

    private static List<LogicBlock> getFluxogramFromCodeBlockList(List<CodeBlock> list){
        List<LogicBlock> identifyedList = identifyLogicBlockFromCodeBlockList(list);

        assign(identifyedList);
        filterList(identifyedList);

        return identifyedList;
    }

    private static void filterList(List<LogicBlock> list) {
        list.removeIf(item -> item.getLogicType() == LogicType.BLOCK_START ||
                item.getLogicType() == LogicType.BLOCK_END ||
                item.getLogicType() == LogicType.STATEMENT);
    }

    private static <T> T getPreviousBefore(List<T> list, T item) {
        int idx = list.indexOf(item);

        if(idx - 2 <= 0) {
            return list.get(idx);
        } else {
            return list.get(idx - 2);
        }
    }

    private static <T> T getPrevious(List<T> list, T item) {
        int idx = list.indexOf(item);

        if(idx == 0) {
            return list.get(idx);
        } else {
            return list.get(idx - 1);
        }
    }

    private static <T> T getNext(List<T> list, T item) {
        int idx = list.indexOf(item);

        if(idx == list.size()) {
            return list.get(idx - 1);
        } else {
            return list.get(idx + 1);
        }
    }

    private static void assign(List<LogicBlock> list) {
        for(var item : list) {
            if(item.getLogicType() == null) {
                continue;
            }

            if(item.getLogicType() == LogicType.BLOCK_START) {
                getPrevious(list, item).setParent(getPreviousBefore(list, item));
                getPrevious(list, item).setInside(getNext(list, item));
            }

            if(
                item.getLogicType() == LogicType.BLOCK_END ||
                item.getLogicType() == LogicType.STATEMENT
            ) {
                getPrevious(list, item).setParent(getPreviousBefore(list, item));
            }
        }
    }

}
