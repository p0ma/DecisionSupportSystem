package system.drilling.model.parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.drilling.model.well.Well;

@Component
public class MudVolume extends Function {

    @Autowired
    private Well well;

    public MudVolume() {
        super("0");
    }

    public MudVolume(String value) {
        super(value);
    }

    @Override
    public void function() throws CrossComputingException {
        setValue(
                Double.toString(
                        Double.parseDouble(model.getParameterValue(Volume1.class))
                                *
                                Double.parseDouble(well.getValue())
                )
        );
    }

    @Override
    public void initListener() {
        if (!isInitialized) {
            model.provideListenerToParameter(this, Volume1.class);
            isInitialized = true;
        }
    }
}
