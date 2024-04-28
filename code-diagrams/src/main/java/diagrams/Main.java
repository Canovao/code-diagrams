package diagrams;


import static diagrams.filters.impl.JavaCleaner.baseJavaFilter;

public class Main {
    public static void main(String[] args) {
        String code = "package com;\n" +
                "\n" +
                "import static com.filters.BaseCleaner.removeAllBlankLinesAnSpaces;\n" +
                "\n" +
                "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello world!\");\n" +
                "    }\n" +
                "}";

        var result = baseJavaFilter(code);

        System.out.println("\n==============================\n");

        System.out.println(result);

        System.out.println("\n==============================\n");
    }
}