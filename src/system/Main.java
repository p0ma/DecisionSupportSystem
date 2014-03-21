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

    private static final String CONFIG_PATH = "classpath*:spring/application-config.xml";

    public static void main(String[] args) {

        final ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
        final Main main = context.getBean(Main.class);

        Casing casing = context.getBean(Casing.class);
        casing.setHeight(2);
        casing.setWidth(3);
        Well well = context.getBean(Well.class);
        System.out.println(well.getValue());


        IModel model = new Model(context);
        model.setParameterValue(MudVolume.class, new Double(200));
        System.out.println(model.getParameterValue(MudVolume.class));

        System.out.println(model.getParameterValue(Volume.class));
        model.setParameterValue(Volume1.class, new Double(60));
        System.out.println(model.getParameterValue(Volume.class));

        for(Map.Entry<String, String> entry : model.getAllValues().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
