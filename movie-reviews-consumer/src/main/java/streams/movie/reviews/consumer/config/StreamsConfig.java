package streams.movie.reviews.consumer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import streams.movie.reviews.consumer.kafkastream.ReviewStreams;

@EnableBinding(ReviewStreams.class)
public class StreamsConfig {
}
