package diagrams.filters.impl;

import diagrams.entity.CodeBlock;
import diagrams.filters.BaseCleaner;

import java.util.ArrayList;
import java.util.List;

public abstract class JavaCleaner extends BaseCleaner {
    private static final List<String> BREAKER_LIST = List.of(
            ";", "{", "}"
    );

    public static String removePackageFromCode(String code){
        return removeAllBetween(code, "package ", ";");
    }

    public static String removeImportsFromCode(String code){
        return removeAllBetween(code, "import ", ";");
    }

    public static List<CodeBlock> baseJavaFilter(String code){
        code = removePackageFromCode(code);
        code = removeImportsFromCode(code);
        code = removeAllBlankLinesAnSpaces(code);
        return stripCodeStringInCodeBlocks(code);
    }

    public static List<CodeBlock> stripCodeStringInCodeBlocks(String code){
        List<CodeBlock> blocks = new ArrayList<>();

        CodeBlock blockBuffer = new CodeBlock();

        for(char c : code.toCharArray()){
            if (BREAKER_LIST.contains(String.valueOf(c))) {
                blocks.add(blockBuffer.finishBlock());
            } else {
                blockBuffer.addChar(c);
            }
        }

        return blocks;
    }
}
