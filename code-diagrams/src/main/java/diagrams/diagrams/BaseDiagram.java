package diagrams.diagrams;

import diagrams.entity.CodeBlock;
import diagrams.entity.LogicBlock;
import diagrams.entity.LogicType;

import java.util.List;

public abstract class BaseDiagram {
    protected static LogicBlock identifyLogicBlockFromCodeBlock(CodeBlock codeBlock){
        if(codeBlock.getCode().equals(";")) {
            return new LogicBlock(codeBlock.getCode(), LogicType.END_STATEMENT);
        }

        if(codeBlock.getCode().equals("{")) {
            return new LogicBlock(codeBlock.getCode(), LogicType.BLOCK_START);
        }

        if(codeBlock.getCode().equals("}")) {
            return new LogicBlock(codeBlock.getCode(), LogicType.BLOCK_END);
        }

        String[] list = codeBlock.getCode().split("if.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.IF);
        }

        list = codeBlock.getCode().split("else if.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.ELSE_IF);
        }

        list = codeBlock.getCode().split("else");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.ELSE);
        }

        list = codeBlock.getCode().split("while.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.WHILE);
        }

        list = codeBlock.getCode().split("do");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.DO_WHILE);
        }

        list = codeBlock.getCode().split("for.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.FOR);
        }

        list = codeBlock.getCode().split("switch.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.SWITCH);
        }

        list = codeBlock.getCode().split("case.*:");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.CASE);
        }

        list = codeBlock.getCode().split("default:");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.DEFAULT);
        }

        list = codeBlock.getCode().split("try");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.TRY);
        }

        list = codeBlock.getCode().split("catch.*\\(");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.CATCH);
        }

        list = codeBlock.getCode().split("finally");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.FINALLY);
        }

        list = codeBlock.getCode().split("throw");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.THROW);
        }

        list = codeBlock.getCode().split("return");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.RETURN);
        }

        list = codeBlock.getCode().split("break");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.BREAK);
        }

        list = codeBlock.getCode().split("continue");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.CONTINUE);
        }

        list = codeBlock.getCode().split("goto");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.GOTO);
        }

        list = codeBlock.getCode().split("label");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.LABEL);
        }

        list = codeBlock.getCode().split("function");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.FUNCTION);
        }

        list = codeBlock.getCode().split("class");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.CLASS);
        }

        list = codeBlock.getCode().split("interface");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.INTERFACE);
        }

        list = codeBlock.getCode().split("enum");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.ENUM);
        }

        list = codeBlock.getCode().split("annotation");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.ANNOTATION);
        }

        list = codeBlock.getCode().split("anonymous class");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.ANONYMOUS_CLASS);
        }

        list = codeBlock.getCode().split("lambda");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.LAMBDA);
        }

        list = codeBlock.getCode().split("block");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.BLOCK);
        }

        list = codeBlock.getCode().split("expression");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.EXPRESSION);
        }

        list = codeBlock.getCode().split("variable");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.VARIABLE);
        }

        list = codeBlock.getCode().split("field");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.FIELD);
        }

        list = codeBlock.getCode().split("method");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.METHOD);
        }

        list = codeBlock.getCode().split("constructor");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.CONSTRUCTOR);
        }

        list = codeBlock.getCode().split("parameter");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.PARAMETER);
        }

        list = codeBlock.getCode().split("argument");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.ARGUMENT);
        }

        list = codeBlock.getCode().split("type");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.TYPE);
        }

        list = codeBlock.getCode().split("literal");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.LITERAL);
        }

        list = codeBlock.getCode().split("operator");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.OPERATOR);
        }

        list = codeBlock.getCode().split("separator");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.SEPARATOR);
        }

        list = codeBlock.getCode().split("comment");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.COMMENT);
        }

        list = codeBlock.getCode().split("empty");

        if(list.length > 1){
            return new LogicBlock(list[1], LogicType.EMPTY);
        }

        if(codeBlock.getCode().startsWith("public static void main(String[] args)")){
            return new LogicBlock(codeBlock.getCode(), LogicType.MAIN);
        }

        return new LogicBlock(codeBlock.getCode(), LogicType.UNKNOWN);
    }

    protected static List<LogicBlock> identifyLogicBlockFromCodeBlockList(List<CodeBlock> codeBlocks){
        List<LogicBlock> logicBlocks = new java.util.ArrayList<>(List.of());

        for(CodeBlock codeBlock : codeBlocks){
            logicBlocks.add(identifyLogicBlockFromCodeBlock(codeBlock));
        }

        return logicBlocks;
    }
}
