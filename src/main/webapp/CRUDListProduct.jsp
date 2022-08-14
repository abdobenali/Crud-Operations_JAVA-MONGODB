<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CrudListProduct</title>
</head>
<body>
<a href="index.jsp">Retour vers l'acceuil</a>
	<form action="AjouterServlet" method="post">
		<label>Document Name</label>
			<input id="1" name="name" type="text" />
		<label>Document Price</label>
			<input id="2" name="price" type="number"/>
		<label>Document Rate</label>
			<input id="3" name="rate" type="number" />
		<button type="submit" class="addbutton" >Ajouter</button>
	</form>
	
	
	<%@include file="UpdatedListProduct.jsp" %>
		
    <style>
    .addbutton {
  		background-color: #4CAF50; /* Green */
 		 border: none;
 		 color: white;
  		padding: 15px 32px;
 		 text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
		}
		.Deletebutton {
  		background-color: red; /* Green */
 		 border: none;
 		 color: white;
  		padding: 15px 32px;
 		 text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
		}
		.Editbutton {
  		background-color: blue; /* Green */
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
    </style>
</body>
</html>