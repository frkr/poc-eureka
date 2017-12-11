package poc.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.net.Socket;

@SpringBootApplication
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        esperarClient();
        SpringApplication.run(Application.class, args);
    }

    static void esperarClient() {
        while (true) {
            try {
                System.out.println(9191);
                new Socket("poc-client", 9191);
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
