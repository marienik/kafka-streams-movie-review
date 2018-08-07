package streams.movie.reviews.consumer.repository;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.transcoder.JsonTranscoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import streams.movie.reviews.consumer.Exception.ReviewJsonConversionException;
import streams.movie.reviews.consumer.config.CouchbaseConfig;
import streams.movie.reviews.consumer.model.MovieReviewMessage;

@Slf4j
@Component
public class CouchbaseRepository implements DataRepository {

    private final JsonTranscoder transcoder;
    private Bucket bucket;
    private final ObjectMapper mapper;

    @Autowired
    public CouchbaseRepository(CouchbaseConfig couchbaseConfig) {

        String[] nodes = couchbaseConfig.getNodes();
        String username = couchbaseConfig.getUsername();
        String password = couchbaseConfig.getPassword();
        String bucketname = couchbaseConfig.getBucketname();

        Cluster cluster = CouchbaseCluster.create(nodes);
        cluster.authenticate(username, password);
        bucket = cluster.openBucket(bucketname);

        transcoder = new JsonTranscoder();
        mapper = new ObjectMapper();
    }

    @Override
    public void addReview(MovieReviewMessage message)    {

        String key = "review" + "_" + message.getMovieId() + "_" + message.getTimestamp();

        RawJsonDocument jsonDoc = RawJsonDocument.create(key, toJsonDocument(message));
        RawJsonDocument retJsonDoc = bucket.insert(jsonDoc);
    }

    private String toJsonDocument(MovieReviewMessage message)
    {
        try {
            return mapper.writeValueAsString(message);
        } catch (Exception e) {
            throw new ReviewJsonConversionException(e.getMessage());
        }
    }
}
