package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.inventory.control.entity.Account;
import jp.co.comnic.javalesson.inventory.control.dao.AccountDao;
import jp.co.comnic.javalesson.inventory.control.dao.DaoException;

/**
 * <p>���O�C���F�؏��������s����Action�C���^�[�t�F�C�X�̎����B</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class LoginAction implements Action {

	/* (non-Javadoc)
	 * @see jp.co.comnic.javalesson.webapp.ems.controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String forwardPath = "login";
		
		try {
			// �N���C�A���g���瑗���Ă������[���E�A�h���X�ƃp�X���[�h���g�p���ĔF�؏�����AccountDao�ɈϏ����A
			// ���ʂ�Account�I�u�W�F�N�g�Ƃ��Ď擾
			Account account = new AccountDao().loginAuthenticate(email, password);
			
			if (account != null && email != "" && password != "") { // �e�[�u���Ƀ}�b�`���郌�R�[�h�����݂���ꍇ�F�ؐ���
				
				// �Z�b�V�����Ǘ����J�n���A�Z�b�V�����̃X�R�[�v�E�I�u�W�F�N�g�ƂȂ�HttpSession��
				// �F�؍ς݂�\��boolean�l�ƃ��O�C���E���[�U�[�����Z�b�g
				request.getSession().setAttribute("isAuthenticated", "AUTHENTICATED");
				request.getSession().setAttribute("loginUsername", account.getUsername());
				request.getSession().setAttribute("loginEmail", email);
				
				// �g�b�v�y�[�W�Ƀ��_�C���N�g
				forwardPath = null;
				response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/main.jsp");

				
			} else {
				request.setAttribute("error", "[ERROR] Invalid e-mail or password.");
				forwardPath = "login";
			}
		} catch (DaoException e) {
			throw new ServletException(e);
		}
		
		return forwardPath;
	}
}
