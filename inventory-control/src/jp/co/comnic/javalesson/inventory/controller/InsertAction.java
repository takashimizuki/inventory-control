package jp.co.comnic.javalesson.inventory.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.inventory.control.dao.BaseDao;
import jp.co.comnic.javalesson.inventory.control.dao.DaoException;
import jp.co.comnic.javalesson.inventory.control.dao.FoodDao;
import jp.co.comnic.javalesson.inventory.control.entity.Food;

public class InsertAction implements Action {

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		
		String redirectPath = "main"; 
		String forwardPath = "new"; 
		String foodName = request.getParameter("foodsid");
		
		
		try {
			
			Food fd = new FoodDao().findByName(foodName);
			
			request.setAttribute("foodsid", fd.getId());	

			Object entity = Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)).newInstance();
			
			
			ControllerUtils.populateEntity(request, entity);
			
		
			new BaseDao().insert(entity);
			
			forwardPath = null;
			response.sendRedirect(redirectPath);
			System.out.println("Insert");
			
		} catch (DaoException e) {
			request.setAttribute("error", "[ERROR]: " + 
			                      ControllerUtils.getShortMessage(e));
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		
		return forwardPath;
	}

}
