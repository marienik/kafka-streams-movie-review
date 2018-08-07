package streams.movie.reviews.consumer.repository;

import streams.movie.reviews.consumer.model.MovieReviewMessage;

public interface DataRepository {

    void addReview(MovieReviewMessage message);
}
