package streams.movie.reviews.consumer.processor;

import org.springframework.messaging.handler.annotation.Payload;
import streams.movie.reviews.consumer.model.MovieReviewMessage;

public interface ReviewProcessor {

    void processReviews(@Payload MovieReviewMessage review);
}
