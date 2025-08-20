package hr.tvz.bilogrevic.zavrsniradbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZavrsniradBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZavrsniradBackendApplication.class, args);
    }

}
