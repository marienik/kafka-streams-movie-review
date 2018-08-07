package streams.movie.reviews.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MovieReviewsConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieReviewsConsumerApplication.class, args);
    }
}
