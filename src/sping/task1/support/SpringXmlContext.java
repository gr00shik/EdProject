package sping.task1.support;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlContext {

    private static SpringXmlContext xmlContext = null;
    private static ApplicationContext context;

    private SpringXmlContext()
    {
        context = new ClassPathXmlApplicationContext("sping/task1/TaskOneConfig.xml");
    }

    public ApplicationContext getContext(){
        return context;
    }

    public static SpringXmlContext getInstance()
    {
        if (xmlContext == null)
            xmlContext = new SpringXmlContext();

        return xmlContext;
    }

}
