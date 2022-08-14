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

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjouterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		int rate =Integer.parseInt(request.getParameter("rate"));		
		Documents doc = new Documents(name,price,rate);
		DataAccess DT = new DocumentDAO();
		DT.save(doc);
		PrintWriter out = response.getWriter() ;
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Ce Produit est cree avec succes !');");
        out.println("window.location.href = \"CRUDListProduct.jsp\";");
        out.println("</script>");
	}

}
