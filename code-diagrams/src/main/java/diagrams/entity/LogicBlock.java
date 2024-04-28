package diagrams.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class LogicBlock extends CodeBlock {
    private LogicBlock next;
    private LogicBlock inside;
    private LogicBlock parent;
    private LogicType logicType;

    public void setNext(LogicBlock next) {
        if(next != this) {
            this.next = next;
        }
    }

    public void setInside(LogicBlock inside) {
        if(inside != this) {
            this.inside = inside;
        }
    }

    public void setParent(LogicBlock parent) {
        if(parent != this) {
            this.parent = parent;
        }
    }

    public void setLogicType(LogicType logicType) {
        this.logicType = logicType;
    }

    public LogicBlock(String code) {
        super(code);
    }

    public LogicBlock() {
    }

    public LogicBlock(String code, LogicType logicType) {
        super(code);
        this.logicType = logicType;
    }

    public LogicBlock(LogicType logicType) {
        this.logicType = logicType;
    }

    public LogicBlock(String code, LogicBlock next, LogicBlock inside, LogicType logicType) {
        super(code);
        this.next = next;
        this.inside = inside;
        this.logicType = logicType;
    }

    public LogicBlock(LogicBlock next, LogicBlock inside, LogicType logicType) {
        this.next = next;
        this.inside = inside;
        this.logicType = logicType;
    }

    public LogicBlock(String code, LogicBlock next, LogicBlock inside, LogicBlock parent, LogicType logicType) {
        super(code);
        this.next = next;
        this.inside = inside;
        this.parent = parent;
        this.logicType = logicType;
    }

    public LogicBlock(LogicBlock next, LogicBlock inside, LogicBlock parent, LogicType logicType) {
        this.next = next;
        this.inside = inside;
        this.parent = parent;
        this.logicType = logicType;
    }
}
