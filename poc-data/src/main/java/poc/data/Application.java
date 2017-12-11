package poc.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.net.Socket;

@SpringBootApplication
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        esperarPostgresEurekaServer();
        SpringApplication.run(Application.class, args);
    }

    static void esperarPostgresEurekaServer() {
        while (true) {
            try {
                System.out.println(5432);
                new Socket("poc-postgres", 5432);
                System.out.println(8761);
                new Socket("poc-eureka", 8761);
                return;
            } catch (Exception e) {
                System.out.println("Connect failed, waiting and trying again");
                try {
                    Thread.sleep(2000);//2 seconds
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
