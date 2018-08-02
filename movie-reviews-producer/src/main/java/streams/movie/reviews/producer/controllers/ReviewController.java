package streams.movie.reviews.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import streams.movie.reviews.producer.model.MovieReview;
import streams.movie.reviews.producer.model.MovieReviewMessage;
import streams.movie.reviews.producer.model.Service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService movieReviewService;


    @RequestMapping(value = "/add/{movieId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addReview(@PathVariable int movieId, @RequestBody MovieReview review)
    {
        MovieReviewMessage message = MovieReviewMessage.builder()
                .movieId(movieId)
                .rating(review.getRating())
                .review(review.getReview())
                .timestamp(System.currentTimeMillis()).build();

        movieReviewService.sendMovieReview(message);
    }
}
