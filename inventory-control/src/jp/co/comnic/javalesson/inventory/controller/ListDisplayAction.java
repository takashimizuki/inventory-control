package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.inventory.control.dao.PurchaseDao;
import jp.co.comnic.javalesson.inventory.control.entity.Purchase;

public class ListDisplayAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email = request.getParameter("email");
//		String foodsId = request.getParameter("foodsId");
//		String price = request.getParameter("price");
//		String quantity = request.getParameter("quantity");
//		String date = request.getParameter("purchaseDate");
//		String consumptionDate = request.getParameter("consumptionDate");
		String forwardPath = "ListDisplay";
		
		
		try {
			
			Purchase purchase = new PurchaseDao().ListDisplay(email);
			
				
			request.getSession().setAttribute("purchaseemail", purchase.getEmail());
//			request.getSession().setAttribute("purchasefoodsId", purchase.getFoodsId());
//			request.getSession().setAttribute("purchaseprice", purchase.getPrice());
//			request.getSession().setAttribute("purchasequantity", purchase.getQuantity());
//			request.getSession().setAttribute("purchasepurchaseDate", purchase.getDate());
//			request.getSession().setAttribute("purchaseconsumptionDate", purchase.getConsumptionDate());	
			System.out.println("request.getSession().setAttribute");
				
			response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/");
				
			forwardPath = null;
				
			
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		
		return forwardPath;
	}
}
