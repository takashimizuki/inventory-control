package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListDisplayAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email = request.getParameter("email");
		int foodsId = request.getParameter("foodsId");
		int price = request.getParameter("price");
		int quantity = request.getParameter("quantity");
		date date = request.getParameter("purchaseDate");
		date consumptionDate = request.getParameter("consumptionDate");
		String forwardPath = "ListDisplay";
		
		
		try {
			
			Purchase account = new AccountDao().loginAuthenticate(email, password);
			
			if (account != null) {
				
				request.getSession().setAttribute("isAuthenticated", "AUTHENTICATED");
				request.getSession().setAttribute("loginUsername", account.getUsername());
				
				response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/");
				
				forwardPath = null;
				
			} else { 
				request.setAttribute("error", "[ERROR] Invalid e-mail or password.");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		return forwardPath;
	}
}
