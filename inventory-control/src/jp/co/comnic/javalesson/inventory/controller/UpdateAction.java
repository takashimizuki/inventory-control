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
		Integer id = Integer.parseInt((String)request.getParameter("id"));
		
		String redirectPath = "main"; // ���폈���̃��_�C���N�g��i�ꗗ��ʁj
		String forwardPath = "edit"; // ��O�������̃t�H���[�h��i���̓o�^��ʁj
		
		try {
			
			BaseDao dao = new BaseDao();
			
			// ���N�G�X�g�E�p�����[�^�[�œn���ꂽID����G���e�B�e�B�E�I�u�W�F�N�g���擾
			Object entity = dao.findById(
					Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)), id);
			
			// ���N�G�X�g�E�p�����[�^�̒l���g�p���ăG���e�B�e�B�E�I�u�W�F�N�g�̃t�B�[���h�l��ݒ�
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
