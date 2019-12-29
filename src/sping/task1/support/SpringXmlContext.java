package sping.task1.support;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlContext {

    private static SpringXmlContext xmlContext = null;
    private static ApplicationContext context;
//    private static AnnotationConfigApplicationContext context;

    private SpringXmlContext()
    {
//        xmlContext
//        context = new ClassPathXmlApplicationContext("sping/task1/configs/XML_Config.xml");

//        JavaConfig
//        context = new AnnotationConfigApplicationContext();
//        context.register(JavaConfig.class);
//        context.refresh();

//        Annotation
        context = new ClassPathXmlApplicationContext("sping/task1/configs/AnnotConfig.xml");
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
