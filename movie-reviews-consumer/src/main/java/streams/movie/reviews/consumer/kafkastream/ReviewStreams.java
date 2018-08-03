package streams.movie.reviews.consumer.kafkastream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;

public interface ReviewStreams {

    String INPUT = "reviews-in";

    @Input(INPUT)
    SubscribableChannel inboundReviews();
}
