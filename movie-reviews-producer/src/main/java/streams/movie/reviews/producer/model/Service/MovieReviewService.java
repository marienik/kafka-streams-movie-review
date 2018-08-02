package streams.movie.reviews.producer.model.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import streams.movie.reviews.producer.kafkastream.ReviewStreams;
import streams.movie.reviews.producer.model.MovieReviewMessage;

@Service
@Slf4j
public class MovieReviewService implements ReviewService {

    @Autowired
    private ReviewStreams reviewStreams;

    public  void sendMovieReview(final MovieReviewMessage review)
    {
        log.info("Sending review {}", review);

        MessageChannel messageChannel = reviewStreams.outboundReviews();
        messageChannel
                .send(MessageBuilder.withPayload(review)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }
}
