package streams.movie.reviews.producer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import streams.movie.reviews.producer.kafkastream.ReviewStreams;

@EnableBinding(ReviewStreams.class)
public class StreamsConfig {
}
