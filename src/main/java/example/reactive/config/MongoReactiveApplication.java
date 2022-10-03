package example.reactive.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.connection.SocketSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.concurrent.TimeUnit;

@EnableReactiveMongoRepositories
public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(
                "mongodb://" + "" + ":" + "" +
                        "@" + "localhost" + ":" + 27017 +
                        "/?authSource=" +
                        "&replicaSet="
        );

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyToSslSettings(builder ->
                        builder.enabled(true).invalidHostNameAllowed(true)
                )
                .applyToConnectionPoolSettings(
                        builder -> builder.minSize(10)
                                .maxSize(100)
                                .maxWaitTime(8, TimeUnit.MINUTES)
                )
                .applyToSocketSettings(builder -> builder.applySettings(SocketSettings.builder().connectTimeout(5,TimeUnit.MINUTES).readTimeout(5,TimeUnit.MINUTES).build()))
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "reactive";
    }

}