package system.drilling.model.parameters;

import java.util.ArrayList;
import java.util.List;

public abstract class Function extends Parameter implements IParameterListener {

    private boolean finalResult;
    protected boolean isInitialized = false;
    protected boolean calculating = false;

    private List<Class<?>> parameters = new ArrayList<Class<?>>();

    public Function() {
        super();
    }

    public Function(Object value) {
        super(value);
    }

    protected abstract void function() throws CrossComputingException;

    public final void calculate() throws CrossComputingException {
        calculating = true;
        function();
        calculating = false;
        finalResult = true;
    }

    protected final void registerDependentParameter(Class<?> parameter) {
        parameters.add(parameter);
        model.provideListenerToParameter(this, parameter);
    }

    protected Object getParameterValue(Class<?> parameter) {
        if (parameters.contains(parameter)) return model.getParameterValue(parameter);
        else {
            registerDependentParameter(parameter);
            return model.getParameterValue(parameter);
        }
    }

    @Override
    public final Object getValue() throws CrossComputingException {
        if (calculating) throw new CrossComputingException();
        if (!finalResult) {
            calculate();
            finalResult = true;
        }
        return value;
    }

    @Override
    public final void parameterChange(ParameterChangeEvent parameterChangeEvent) {
        finalResult = false;
    }

    public void setFinalResult(boolean finalResult) {
        this.finalResult = finalResult;
    }
}
