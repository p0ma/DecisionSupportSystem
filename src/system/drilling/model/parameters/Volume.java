package system.drilling.model.parameters;

import org.springframework.stereotype.Component;

@Component
public class Volume extends Function {

    public Volume() {
        super();
    }

    public Volume(Object value) {
        super(value);
    }

    @Override
    protected void function() throws CrossComputingException {
        setValue(((Double) getParameterValue(Volume1.class) +
                (Double) getParameterValue(Volume2.class) +
                (Double) getParameterValue(MudVolume.class)));
    }
}
