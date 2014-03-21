package system.drilling.model.parameters;

import org.springframework.stereotype.Component;

@Component
public class Volume2 extends Parameter {

    public Volume2() {
        super("0");
    }

    public Volume2(String value) {
        super(value);
    }
}
