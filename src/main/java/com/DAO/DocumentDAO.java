package com.DAO;
import org.bson.Document;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.models.Documents;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
//import com.mongodb.o;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.model.Filters.*;

import MongoDBConnection.ConnectionMongoDB;

public class DocumentDAO implements DataAccess<Documents> {

	@Override
	public void save(Documents e) {
		try {
			ConnectionMongoDB o = new ConnectionMongoDB();
			//MongoClient clientMongo = o.getMongoDBClient();
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase db = mongoClient.getDatabase("Document");
			
			Document d1 = new Document();
            d1.append("name", e.getName());
            d1.append("price",e.getPrice());
            d1.append("rate", e.getRate());
            db.getCollection("DocumentList").insertOne(d1);
            System.out.println("product added");
            System.out.println(db);
        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }
		
	}

	

	@Override
	public void delete(Documents e) {
		ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient clientMongo = o.getMongoDBClient();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		MongoCollection collection = db.getCollection("DocumentList");
		
		
		BasicDBObject theQuery = new BasicDBObject();
		theQuery.put("name", e.getName());
		System.out.println(e.getName());
		DeleteResult result = collection.deleteMany(theQuery);
		
	}

	@Override
	public List<Documents> findAll() {
		ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
	     MongoCollection<Document> collection = db.getCollection("DocumentList");

		FindIterable<Document> iterDoc = collection.find();
	      Iterator it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	      }
		
		return null;
	}

	@Override
	public boolean find(Documents e) {
		return true;
	}

	@Override
	public void update(Documents e, Documents e1) {
		ConnectionMongoDB o = new ConnectionMongoDB();
		//MongoClient clientMongo = o.getMongoDBClient();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		
		BasicDBObject query = new BasicDBObject();
		query.put("name", e.getName()); // (1)

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", e1.getName()); // (2)
		
		BasicDBObject query1 = new BasicDBObject();
		query.put("price", e.getName()); // (1)

		BasicDBObject newDocument1 = new BasicDBObject();
		newDocument.put("price", e1.getName()); // (2)
		
		BasicDBObject query2 = new BasicDBObject();
		query.put("rate", e.getName()); // (1)

		BasicDBObject newDocument2 = new BasicDBObject();
		newDocument.put("rate", e1.getName()); // (2)

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument); // (3)

		db.getCollection("webHostInfo").updateOne(query, updateObject); // (4)
	}

}
