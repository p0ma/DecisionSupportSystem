package system.drilling.model;

import system.drilling.model.parameters.IParameter;
import system.drilling.model.parameters.IParameterListener;

import java.util.List;
import java.util.Map;

public interface IModel {
    public Object getParameterValue(Class<?> key);
    public Model addParameter(IParameter parameter);
    public Model setParameterValue(Class<?> key, Object value);
    public void provideListenerToParameter(IParameterListener parameterListener, Class<?> key);
    public Map<String, String> getAllValues();
}
