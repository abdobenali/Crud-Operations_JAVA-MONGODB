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
	import ="java.io.PrintWriter"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
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
	button {
  		background-color: #4CAF50; /* Green */
 		 border: none;
 		 color: white;
  		padding: 15px 32px;
 		 text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		fo

</style>
<jsp:scriptlet>
   		name = request.getParameter("name");
   		price = Float.parseFloat(request.getParameter("price"));
   		rate = Integer.parseInt(request.getParameter("rate"));
   		Documents doc = new Documents(name,price,rate);
   		DataAccess DT = new DocumentDAO();
   		DT.delete(doc);
   </jsp:scriptlet>
   <jsp:declaration>
   	String name="";
   	float price;
   	Integer rate;
   </jsp:declaration>
   <% 
   %>
<form action="EditServlet" method="post">
	<label>NAME
		<input name="name" type="text" value=<jsp:expression>name</jsp:expression>	>
	</label>
	<label>PRICE
		<input name="price"  type="number" value=<jsp:expression>price</jsp:expression>	>
	</label>
	<label>RATE
		<input name="rate" type="number" value=<jsp:expression>rate</jsp:expression>	>
	</label>
	<button type="submit" class="savebutton">save modification</button>   
</form>
<form>
	
</form>
	

</body>
</html>