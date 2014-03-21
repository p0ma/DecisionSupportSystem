package system.drilling.model.parameters;

public abstract class Function extends Parameter implements IParameterListener {

    private boolean finalResult;
    protected boolean isInitialized = false;
    protected boolean calculating = false;

    public Function(String value) {
        super(value);
    }

    protected abstract void function() throws CrossComputingException;

    public final void calculate() throws CrossComputingException {
        calculating = true;
        function();
        calculating = false;
        finalResult = true;
    }

    @Override
    public final String getValue() throws CrossComputingException {
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

    @Override
    public abstract void initListener();

    public void setFinalResult(boolean finalResult) {
        this.finalResult = finalResult;
    }
}
