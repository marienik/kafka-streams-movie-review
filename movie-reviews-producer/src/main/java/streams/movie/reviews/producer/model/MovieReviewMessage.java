package streams.movie.reviews.producer.model;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class MovieReviewMessage {

    private String review;
    private int rating;
    private long timestamp;
    private int movieId;
}
