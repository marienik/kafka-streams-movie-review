package streams.movie.reviews.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import streams.movie.reviews.consumer.kafkastream.ReviewStreams;
import streams.movie.reviews.consumer.model.MovieReviewMessage;

@Component
@Slf4j
public class MovieReviewProcessor implements ReviewProcessor {

    @StreamListener(ReviewStreams.INPUT)
    @Override
    public void processReviews(MovieReviewMessage review) {

        System.out.println(review.getReview());
    }
}
