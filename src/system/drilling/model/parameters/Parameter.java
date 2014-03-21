package system.drilling.model.parameters;

import system.drilling.model.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Parameter implements IParameter {

    protected String value;
    protected Model model;

    public Parameter(String value) {
        this.value = value;
    }

    public final void setValue(String value) {
        if (!this.value.equals(value)) {
            notifyListeners(this, this.value, value);
            this.value = value;
        }
    }

    @Override
    public String getValue() throws CrossComputingException {
        return value;
    }

    @Override
    public final void setModel(Model model) {
        this.model = model;
    }

    public final Model getModel() {
        return model;
    }

    private List<IParameterListener> parameterListeners = new ArrayList<IParameterListener>();

    private void notifyListeners(Object object, String oldValue, String newValue) {
        for (IParameterListener parameterListener : parameterListeners) {
            parameterListener.parameterChange(new ParameterChangeEvent(object, oldValue, newValue));
        }
    }

    @Override
    public final void addListener(IParameterListener parameterListener) {
        parameterListeners.add(parameterListener);
    }

    @Override
    public final void detachListener(IParameterListener parameterListener) {
        parameterListeners.remove(parameterListener);
    }
}
