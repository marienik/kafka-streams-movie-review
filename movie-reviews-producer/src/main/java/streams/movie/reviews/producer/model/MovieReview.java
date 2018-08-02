package streams.movie.reviews.producer.model;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class MovieReview {
    private String review;
    private int rating;
}
