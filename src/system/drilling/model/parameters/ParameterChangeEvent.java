package system.drilling.model.parameters;

public class ParameterChangeEvent {

    private Object object;
    private String oldValue;
    private String newValue;

    public ParameterChangeEvent(Object object, String oldValue, String newValue) {

    }

    public Object getObject() {
        return object;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }
}
