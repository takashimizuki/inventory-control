package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.inventory.control.dao.BaseDao;
import jp.co.comnic.javalesson.inventory.control.dao.DaoException;


public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
//		Integer id = Integer.parseInt((String)request.getParameter("id"));
//		String id = request.getParameter("id");
		Integer id = Integer.parseInt(request.getParameter("id"));

		String redirectPath = "main"; 
		String forwardPath = "edit"; 
		
		try {
			
			BaseDao dao = new BaseDao();
			
			
			Object entity = dao.findById(
					Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)), id);
			
			// リクエスト・パラメータの値を使用してエンティティ・オブジェクトのフィールド値を設定
			ControllerUtils.populateEntity(request, entity);
			
			new BaseDao().update(entity);
			
			forwardPath = null;
			response.sendRedirect(redirectPath); 
			
		} catch (DaoException e) {
			request.setAttribute("error", "[ERROR]: " + 
			                      ControllerUtils.getShortMessage(e));
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		
		return forwardPath;
	}
}
