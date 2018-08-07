package streams.movie.reviews.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "couchbase")
public class CouchbaseConfig {

    @NotNull
    private String[] nodes;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String bucketname;
}
