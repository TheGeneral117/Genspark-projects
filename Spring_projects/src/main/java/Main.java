import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        ApplicationContext configContext = new AnnotationConfigApplicationContext(AppConfig.class);


        Phone p = (Phone) context.getBean("Phone");
        System.out.println(p.getMob());

        Address a = configContext.getBean(Address.class);
        System.out.println(a);

        Student s = configContext.getBean(Student.class);
        System.out.println(s);
    }
}
