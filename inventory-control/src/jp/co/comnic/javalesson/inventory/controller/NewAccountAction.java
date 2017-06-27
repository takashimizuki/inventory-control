package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.inventory.control.dao.BaseDao;
import jp.co.comnic.javalesson.inventory.control.dao.DaoException;

/**
 * <p>���R�[�h�̐V�K�}�������s����Action�C���^�[�t�F�C�X�̎����B</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class NewAccountAction implements Action {

	/* (non-Javadoc)
	 * @see jp.co.comnic.javalesson.webapp.ems.controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		// this string is -> /new-account.do
		
		String redirectPath = "login"; // ���폈���̃��_�C���N�g��i�ꗗ��ʁj
//		response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/login.jsp");
		String forwardPath = "new-account"; // ��O�������̃t�H���[�h��i���̓o�^��ʁj
		
		try {
			
			// サーブレットパスをコントロールユーティルズに渡し、返り値からインスタンスを生成する
			//　
			Object entity = Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)).newInstance();
			
			// servletRequestとオブジェクトを渡し、エンティティクラスに
			ControllerUtils.populateEntity(request, entity);
			
			// �G���e�B�e�B�E�I�u�W�F�N�g��DAO�ɓn�����ƂŐV�K���R�[�h��DB�ɑ}��
			new BaseDao().insert(entity);
			
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
