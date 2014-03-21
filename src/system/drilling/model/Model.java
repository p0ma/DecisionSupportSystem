package system.drilling.model;

import system.drilling.model.parameters.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    private Map<String, IParameter> parameterMap = new HashMap<String, IParameter>();

    public Model() {
    }

    public String getParameterValue(String key) {
        try{
            return parameterMap.get(key).getValue();
        }catch(CrossComputingException e) {
            e.printStackTrace();
        }
        return "0";
    }

    public String getParameterValue(Class<?> key) {
        return getParameterValue(key.getSimpleName());
    }

    public Model addParameter(String key, IParameter parameter) {
        parameterMap.put(key, parameter);
        parameter.setModel(this);
        if(parameter instanceof Function) ((Function) parameter).initListener();
        return this;
    }

    public Model addParameter(IParameter parameter) {
        addParameter(parameter.getClass().getSimpleName(), parameter);
        return this;
    }

    public Model setParameterValue(String key, String value) {
        parameterMap.get(key).setValue(value);
        return this;
    }

    public Model setParameterValue(Class<?> key, String value) {
        setParameterValue(key.getSimpleName(), value);
        return this;
    }

    public void provideListenerToParameter(IParameterListener parameterListener, String key) {
        parameterMap.get(key).addListener(parameterListener);
    }

    public void provideListenerToParameter(IParameterListener parameterListener, Class<?> key) {
        provideListenerToParameter(parameterListener, key.getSimpleName());
    }

    public void renewResults() {
        for(IParameter parameter : parameterMap.values()) {
            if(parameter instanceof Function)
            {
                ((Function) parameter).setFinalResult(false);
            }
        }
    }

   /* public static class Builder {
        public Volume1 volume1;
        public Volume2 volume2;
        public Volume volume;
        public MudVolume innerVolume;
        {
            volume = new Volume("0");
            volume1 = new Volume1("0");
            volume2 = new Volume2("0");
            innerVolume = new MudVolume("0");
        }

        public Builder volume1(String volume1) {
            this.volume1.setValue(volume1);
            return this;
        }

        public Builder volume2(String volume2) {
            this.volume2.setValue(volume2);
            return this;
        }

        public Builder volume(String volume) {
            this.volume.setValue(volume);
            return this;
        }

        public Builder innerVolume(String innerVolume) {
            this.innerVolume.setValue(innerVolume);
            return this;
        }

        public Model build() {
            return new Model(this);
        }
    }*/
}
