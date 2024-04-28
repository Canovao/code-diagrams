package diagrams.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicBlock extends CodeBlock {
    private LogicType logicType;

    public LogicBlock(String code) {
        super(code);
    }

    public LogicBlock() {
        super();
    }

    public LogicBlock(String code, LogicType logicType) {
        super(code);
        this.logicType = logicType;
    }

    public LogicBlock(LogicType logicType) {
        this.logicType = logicType;
    }
}
