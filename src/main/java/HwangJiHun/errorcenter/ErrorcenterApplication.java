package HwangJiHun.errorcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ErrorcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorcenterApplication.class, args);
	}

}
