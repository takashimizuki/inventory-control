package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>���O�A�E�g�F�؏��������s����Action�C���^�[�t�F�C�X�̎����B</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class LogoutAction implements Action {

	/* (non-Javadoc)
	 * @see jp.co.comnic.javalesson.webapp.ems.controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().invalidate(); // �Z�b�V�����Ǘ��𖳌��ɂ���(HttpSession�I�u�W�F�N�g�̔j��)
		response.sendRedirect("login"); // ���O�C����ʂɃ��_�C���N�g
		
		return null;
	}

}
