package streams.movie.reviews.producer.kafkastream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ReviewStreams {

    String OUTPUT = "reviews-out";

    @Output(OUTPUT)
    MessageChannel outboundReviews();
}
