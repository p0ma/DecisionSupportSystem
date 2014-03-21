package system;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import system.drilling.model.IModel;
import system.drilling.model.Model;
import system.drilling.model.parameters.*;
import system.drilling.model.well.Casing;
import system.drilling.model.well.Well;

import java.util.Map;

@Component
public class Main {

    private static final String MODEL_CONFIG_PATH = "classpath*:system/drilling/model/config.xml";

    public static void main(String[] args) {

        final ApplicationContext modelContext = new ClassPathXmlApplicationContext(MODEL_CONFIG_PATH);

        Casing casing = modelContext.getBean(Casing.class);
        casing.setHeight(2);
        casing.setWidth(3);
        Well well = modelContext.getBean(Well.class);
        System.out.println(well.getValue());


        IModel model = new Model(modelContext);
        model.setParameterValue(MudVolume.class, new Double(200));
        model.setParameterValue(Volume.class, new Double(60));

        for(Map.Entry<String, String> entry : model.getAllValues().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        for(Map.Entry<String, String> entry : model.setParameterValue(Volume1.class, new Double(30))
                .getAllValues().entrySet())
        {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
