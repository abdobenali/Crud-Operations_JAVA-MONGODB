<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.bson.Document"

	import="java.util.ArrayList"
	import="java.util.Iterator"
	import="java.util.List"
	import="com.models.Documents"
	import="com.mongodb.client.FindIterable"
	import="com.mongodb.client.MongoClient"
	import="com.mongodb.client.MongoClients"
	import="com.mongodb.client.MongoCollection"
	import="com.mongodb.client.MongoDatabase"
	
	import="com.mongodb.BasicDBObject"
	import="com.mongodb.client.MongoCursor"
	import="MongoDBConnection.ConnectionMongoDB"
	
	import="com.mongodb.DBObject"
	import="com.mongodb.client.model.Filters"
	import= "com.mongodb.client.result.DeleteResult"
	import ="javax.servlet.http.HttpServletRequest"
	import=" com.DAO.DataAccess"
	import="com.DAO.DocumentDAO"
    %>
	<%
		ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient clientMongo = o.getMongoDBClient();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		MongoCollection collection = db.getCollection("DocumentList");
		BasicDBObject doc = new BasicDBObject();
		MongoCursor<Document> cursor = collection.find().iterator();
		int rec=1;
		
		try {
		       while(cursor.hasNext()) 
		       {
		    	   Document str= cursor.next();
		    	  
		    	   %>
		    	  <!-- <form action="Edit.jsp" method="post"> --> 
		    	  <form action="Edit.jsp" method="post">
		    	   <table>
		    	   		<tr>
    						<th>Name</th>
    						<th>Price</th>
   							<th>Rate</th>
  						</tr>
  						<tr>
    						<td >
    							<input id="name" name="name" value="<%out.println(str.get("name")); %>" readonly/>
		    	  			</td>
    						<td>
    							<input id="price" name="price" value="<%out.println(str.get("price")); %>"  readonly/>
    							
		    	   			</td>
    						<td name="rate">
								<input id="rate" name="rate" value="<%out.println(str.get("rate")); %>" readonly />
		    	   			</td>
    						<td>
    							<button type="submit" class="Editbutton">Edit</button>
    						</td>
    						<td>
    							<button type="submit"  formaction="DeleteServlet" formmethod="POST" class="Deletebutton">Delete</button>
    						</td>
  						 </tr>
  						   
  						 
		    	   
		    	   
		    	   </table>
		    	   </form>
		    	   <% 
		       }
		    	} 
		    finally 
		    {
		       cursor.close();
		    }
		    

	%>
	
	
