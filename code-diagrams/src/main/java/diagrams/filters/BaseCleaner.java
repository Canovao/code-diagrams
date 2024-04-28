package diagrams.filters;

public abstract class BaseCleaner {
    public static String removeAllUselessSpaces(String code){
        return code.replace("  ", " ");
    }

    public static String removeAllBlankLines(String code){
        return code.replace("\n", " ");
    }

    public static String removeAllBlankLinesAndSpaces(String code){
        return removeAllUselessSpaces(removeAllBlankLines(code));
    }

    public static String removeAllBetween(String code, String start, String end){
        return code.replaceAll(start + ".+" + end, "");
    }
}
