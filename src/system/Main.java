package system;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import system.drilling.model.Model;
import system.drilling.model.dataset.DataSet;
import system.drilling.model.parameters.*;
import system.drilling.model.well.Casing;
import system.drilling.model.well.Well;

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


        Model model = new Model();
        model.addParameter(context.getBean(Volume1.class))
                .addParameter(context.getBean(Volume2.class))
                .addParameter(context.getBean(Volume.class))
                .addParameter(context.getBean(MudVolume.class))
                .setParameterValue(Volume1.class, "30")
                .setParameterValue(Volume2.class, "40");

        System.out.println(model.getParameterValue(Volume.class));
        model.setParameterValue(Volume1.class, "25");
        System.out.println(model.getParameterValue(Volume.class));
    }

}
