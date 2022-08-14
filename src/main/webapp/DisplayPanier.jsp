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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
<a href="index.jsp">Retour vers l'acceuil</a>
<%
		ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient clientMongo = o.getMongoDBClient();
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		MongoCollection collection = db.getCollection("PanierDesDocuments");
		BasicDBObject doc = new BasicDBObject();
		MongoCursor<Document> cursor = collection.find().iterator();
		int rec=1;
		
		try {
		       while(cursor.hasNext()) 
		       {
		    	   Document str= cursor.next();
		    	  
		    	   %>
		    	  <!-- <form action="Edit.jsp" method="post"> --> 
		    	  <form action="DeleteFromPanierServlet" method="post">
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
    							<button type="submit">Delete from panier</button>
    						</td>
  						 </tr>
  						   
  						 
		    	   
		    	   
		    	   </table>
		    	  
		    	   <% 
		       }
		    	} 
		    finally 
		    {
		       cursor.close();
		    }
		    

	%>
	 </form>
	 <input type="button" style="background-color: yellow" value="Imprimer cette page" onClick="window.print()">
	 
<style>
    	a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
	}

	a:hover, a:active {
  	background-color: red;
	}
	 button {
  		background-color: #4CAF50; /* Green */
 		 border: none;
 		 color: white;
  		padding: 15px 32px;
 		 text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
		}
		input{
  			width: 100%;
  			box-sizing: border-box;
  			border: 2px solid #ccc;
  			border-radius: 4px;
  			font-size: 16px;
  			background-color: white;
  
  			background-position: 10px 10px; 
  				background-repeat: no-repeat;
  			padding: 12px 20px 12px 40px;
			}			
    </style>
</body>
</html>