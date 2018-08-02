package streams.movie.reviews.producer.model.Service;

import streams.movie.reviews.producer.model.MovieReview;
import streams.movie.reviews.producer.model.MovieReviewMessage;

public interface ReviewService {

    void sendMovieReview(final MovieReviewMessage review);
}
