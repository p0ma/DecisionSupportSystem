package system.drilling.model.parameters;

import org.springframework.stereotype.Component;

@Component
public class Volume extends Function{

    public Volume() {
        super("0");
    }

    public Volume(String value) {
        super(value);
    }

    public void initListener() {
        if (!isInitialized) {
            model.provideListenerToParameter(this, Volume1.class);
            model.provideListenerToParameter(this, Volume2.class);
            model.provideListenerToParameter(this, Volume2.class);
            isInitialized = true;
        }
    }

    @Override
    protected void function() throws CrossComputingException {
        setValue(Double.toString(Double.parseDouble(model.getParameterValue(Volume1.class)) +
                Double.parseDouble(model.getParameterValue(Volume2.class)) +
                Double.parseDouble(model.getParameterValue(MudVolume.class))));
    }
}
