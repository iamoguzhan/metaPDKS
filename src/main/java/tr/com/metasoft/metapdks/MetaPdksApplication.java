package tr.com.metasoft.metapdks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class MetaPdksApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaPdksApplication.class, args);
    }

}
