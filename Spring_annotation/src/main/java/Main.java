import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext configContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Student s = configContext.getBean(Student.class);
        System.out.println(s);
    }
}
