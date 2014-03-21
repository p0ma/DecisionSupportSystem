package system.drilling.model.parameters;

import system.drilling.model.IModel;
import system.drilling.model.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Parameter implements IParameter {

    protected Object value;
    protected IModel model;

    public Parameter() {
        value = new Double(0);
    }

    public Parameter(Object value) {
        this.value = value;
    }

    public final void setValue(Object value) {
        if (value != this.value) {
            try {
                if (!this.value.equals(value)) {
                    notifyListeners(this, this.value, value);
                    this.value = value;
                }
            } catch (NullPointerException e) {
                notifyListeners(this, this.value, value);
                this.value = value;
            }
        }
    }

    @Override
    public Object getValue() throws CrossComputingException {
        return value;
    }

    @Override
    public final void setModel(Model model) {
        this.model = model;
    }

    public final IModel getModel() {
        return model;
    }

    private List<IParameterListener> parameterListeners = new ArrayList<IParameterListener>();

    private void notifyListeners(Object object, Object oldValue, Object newValue) {
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
