package system.drilling.model.parameters;

import org.springframework.stereotype.Component;

@Component
public class Volume1 extends Parameter {

    public Volume1() {
        super("0");
    }

    public Volume1(String value) {
        super(value);
    }
}
