package pers.yuezejian.coldchainlogistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ColdchainlogisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColdchainlogisticsApplication.class, args);
    }

}
