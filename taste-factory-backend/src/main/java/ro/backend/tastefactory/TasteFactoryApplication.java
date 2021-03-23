package ro.backend.tastefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class TasteFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasteFactoryApplication.class, args);
    }
}
