package spring;

import system.drilling.model.dataset.DataSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MinimalSpringApp {

    private static final String CONFIG_PATH = "classpath*:spring/application-config.xml";

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
        final MinimalSpringApp minimalSpringApp = context.getBean(MinimalSpringApp.class);

        DataSet dataSet = (DataSet) context.getBean(DataSet.class);
        dataSet.setFluidIntensity(200);
        System.out.println(dataSet.getFluidIntensity());

    }

}

