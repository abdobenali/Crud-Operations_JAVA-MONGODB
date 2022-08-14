package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataAccess;
import com.DAO.DocumentsDAOClient;
import com.models.Documents;

/**
 * Servlet implementation class DeleteFromPanierServlet
 */
@WebServlet("/DeleteFromPanierServlet")
public class DeleteFromPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromPanierServlet() {
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
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		int rate =Integer.parseInt(request.getParameter("rate"));		
		Documents doc = new Documents(name,price,rate);
		DataAccess DT = new DocumentsDAOClient();
		DT.delete(doc);
		PrintWriter out = response.getWriter() ;
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Ce Produit est supprimer du panier avec succes !');");
        out.println("window.location.href = \"DisplayPanier.jsp\";");
        out.println("</script>");
	}

}
