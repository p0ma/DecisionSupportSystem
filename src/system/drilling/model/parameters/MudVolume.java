package system.drilling.model.parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.drilling.model.well.Well;

@Component
public class MudVolume extends Function {

    @Autowired
    private Well well;

    public MudVolume() {
        super(null);
    }

    public MudVolume(String value) {
        super(value);
    }

    @Override
    public void function() throws CrossComputingException {
        setValue(
                (Double) getParameterValue(Volume1.class)
                        *
                        (Double) well.getValue()
                        + (Double) getParameterValue(Pressure.class)
        );
    }

    @Override
    protected void registerDependentParameters() {
        registerDependentParameter(Volume1.class);
        registerDependentParameter(Pressure.class);
    }


}
