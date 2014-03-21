package system.drilling.model.parameters;

import system.drilling.model.Model;

public interface IParameter extends IListenable {

    public Object getValue() throws CrossComputingException;

    public void setModel(Model model);

    public void setValue(Object value);
}
