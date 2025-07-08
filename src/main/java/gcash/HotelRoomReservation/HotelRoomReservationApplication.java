package gcash.HotelRoomReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ApplicationService;

@SpringBootApplication(scanBasePackages = {"service"})
public class HotelRoomReservationApplication implements CommandLineRunner {

	@Autowired
	private ApplicationService applicationService;

	public static void main(String[] args) {
		SpringApplication.run(HotelRoomReservationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		applicationService.execute();
	}
}
