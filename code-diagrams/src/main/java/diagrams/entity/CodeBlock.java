package diagrams.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CodeBlock {
    private String code = "";

    public CodeBlock(String code) {
        this.code = code.trim();
    }

    public void addChar(char c) {
        code = code + c;
    }

    public CodeBlock finishBlock() {
        String buffer = code;
        code = "";
        return new CodeBlock(buffer);
    }
}
