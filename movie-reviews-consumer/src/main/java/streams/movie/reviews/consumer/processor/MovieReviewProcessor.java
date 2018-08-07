package streams.movie.reviews.consumer.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import streams.movie.reviews.consumer.kafkastream.ReviewStreams;
import streams.movie.reviews.consumer.model.MovieReviewMessage;
import streams.movie.reviews.consumer.repository.DataRepository;

import java.util.Calendar;
import java.util.Date;

@Component
@Slf4j
public class MovieReviewProcessor implements ReviewProcessor {

    @Autowired
    private DataRepository couchbaseRepository;


    @StreamListener(ReviewStreams.INPUT)
    @Override
    public void processReviews(MovieReviewMessage review) {

        couchbaseRepository.addReview(review);

    }
}
