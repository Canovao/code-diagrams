package diagrams.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CodeBlock {
    private String code = "";

    public void addChar(char c) {
        code = code + c;
    }

    public CodeBlock finishBlock() {
        String buffer = code;
        code = "";
        return new CodeBlock(buffer);
    }
}
