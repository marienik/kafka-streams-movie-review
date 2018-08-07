package streams.movie.reviews.consumer.Exception;

import org.springframework.core.convert.ConversionException;

public class ReviewJsonConversionException extends ConversionException {

    public ReviewJsonConversionException(String message) {
        super(message);
    }

    public ReviewJsonConversionException(String message, Throwable t) {
        super(message, t);
    }
}
