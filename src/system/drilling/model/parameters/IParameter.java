package system.drilling.model.parameters;

import system.drilling.model.Model;

public interface IParameter extends IListenable {

    public String getValue() throws CrossComputingException;

    public void setModel(Model model);

    public void setValue(String value);
}
