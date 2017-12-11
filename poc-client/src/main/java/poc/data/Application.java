package poc.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Socket;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        esperarData();
        SpringApplication.run(Application.class, args);
    }

    static void esperarData() {
        while (true) {
            try {
                System.out.println(9090);
                new Socket("poc-data", 9090);
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
