package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataAccess;
import com.DAO.DocumentDAO;
import com.models.Documents;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class UpdateListProductServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		int rate =Integer.parseInt(request.getParameter("rate"));
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("Document");
		Documents doc = new Documents(name,price,rate);
		DataAccess DT = new DocumentDAO();
		DT.save(doc);
		PrintWriter out = response.getWriter() ;
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Ce Produit est sauvegarder avec succes !');");
        out.println("window.location.href = \"CRUDListProduct.jsp\";");
        out.println("</script>");
		

	}

}
