import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    Integer id(){return 117;}

    @Bean
    String name(){return "John";}

    @Bean
    List<Phone> phones(){
        List<Phone> number = new ArrayList<>();
        number.add(new Phone("555-555-5555"));
        number.add(new Phone("777-777-7777"));
        number.add(new Phone("333-333-3333"));
        return number;
    }

    @Bean
    Address address(){ return new Address("Manhattan","New York","USA","10170");}
}
