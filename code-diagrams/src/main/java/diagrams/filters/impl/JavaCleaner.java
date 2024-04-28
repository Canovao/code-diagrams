package diagrams.filters.impl;

import diagrams.entity.CodeBlock;
import diagrams.filters.BaseCleaner;

import java.util.ArrayList;
import java.util.List;

public abstract class JavaCleaner extends BaseCleaner {
    private static final List<String> BREAKER_LIST = List.of(
            ";", "{", "}"
    );

    private static String removePackageFromCode(String code){
        return removeAllBetween(code, "package ", ";");
    }

    private static String removeImportsFromCode(String code){
        while(code.contains("import ")) {
            code = removeAllBetween(code, "import ", ";");
        }
        return code.trim();
    }

    public static List<CodeBlock> baseJavaFilter(String code){
        code = removePackageFromCode(code);
        code = removeImportsFromCode(code);
        code = removeAllBlankLinesAndSpaces(code);
        return stripCodeStringInCodeBlocks(code);
    }

    private static List<CodeBlock> stripCodeStringInCodeBlocks(String code){
        List<CodeBlock> blocks = new ArrayList<>();

        CodeBlock blockBuffer = new CodeBlock();

        for(char c : code.toCharArray()){
            if (BREAKER_LIST.contains(String.valueOf(c))) {
                if (!blockBuffer.getCode().isEmpty() && !blockBuffer.getCode().isBlank()) {
                    blockBuffer.setCode(blockBuffer.getCode().trim());
                    blocks.add(blockBuffer.finishBlock());
                }

                blocks.add(new CodeBlock(String.valueOf(c)));
            } else {
                blockBuffer.addChar(c);
            }
        }

        return blocks;
    }
}
