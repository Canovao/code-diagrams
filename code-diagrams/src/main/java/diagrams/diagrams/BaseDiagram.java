package diagrams.diagrams;

import diagrams.entity.CodeBlock;
import diagrams.entity.LogicBlock;
import diagrams.entity.LogicType;

import java.util.List;

public abstract class BaseDiagram {
    protected LogicBlock identifyLogicFromCodeBlock(CodeBlock codeBlock){
        String[] list = codeBlock.getCode().split("if.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.IF);
        }

        return null;
    }
}
