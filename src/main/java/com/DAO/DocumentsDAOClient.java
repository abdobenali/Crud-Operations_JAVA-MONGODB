package com.DAO;

import java.util.List;

import org.bson.Document;

import com.models.Documents;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import MongoDBConnection.ConnectionMongoDB;

public class DocumentsDAOClient implements DataAccess<Documents> {

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
            db.getCollection("PanierDesDocuments").insertOne(d1);
            System.out.println("product added");
            System.out.println(db);
        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }
		
	}

	@Override
	public void update(Documents e, Documents e1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Documents e) {
		ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient clientMongo = o.getMongoDBClient();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		MongoCollection collection = db.getCollection("PanierDesDocuments");
		
		
		BasicDBObject theQuery = new BasicDBObject();
		theQuery.put("name", e.getName());
		System.out.println(e.getName());
		DeleteResult result = collection.deleteMany(theQuery);
		
	}

	@Override
	public List<Documents> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean find(Documents e) {
		// TODO Auto-generated method stub
		//db.collection.find({_id: “myId”}, {_id: 1}).limit(1);
		ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient clientMongo = o.getMongoDBClient();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		MongoCollection collection = db.getCollection("PanierDesDocuments");
		MongoCursor<Document> cursor = collection.find().iterator();
		//boolean b = false;
		//System.out.println(e.getName());
		//int rec=1;
		
		       while(cursor.hasNext()) 
		       {
		    	   Document str= cursor.next();
		    	   System.out.println("************************");
		    	   System.out.println(str.get("name"));
		    	   System.out.println(e.getName());
		    	   System.out.println("************************");
		    	   
		    	   if(e.getName() == str.get("name")) {
		    		   System.out.println("true");
		    		   return true; 
		    	   }
		    	   
		       }
		       return false ;
		    	
		    
		
	}

}
