package MongoDBConnection;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectionMongoDB {

	public  MongoClient getMongoDBClient() {
		//MongoClient client = MongoClients.create();
		String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Document");
            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server.");
                MongoCollection < Document > collection = database.getCollection("DocumentList");
                
                return	mongoClient;
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }

	}
		return null;

	}
	}
