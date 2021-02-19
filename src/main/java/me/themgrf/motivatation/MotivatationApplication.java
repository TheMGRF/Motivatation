package me.themgrf.motivatation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.minecrossing.databaseconnector.DatabaseConnector;
import xyz.minecrossing.databaseconnector.DatabaseDetails;

@SpringBootApplication
public class MotivatationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotivatationApplication.class, args);

        DatabaseConnector.getInstance().addDatabase(new DatabaseDetails(
                "127.0.0.1",
                3306,
                "motivatation",
                "motivate",
                "password"
        ));

        Motivatation.getInstance().setupItems();
    }

}
