package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	/**
	 * <p>�r�W�l�X�E���W�b�N�����s����Action�N���X�̂��߂̃C���^�[�t�F�C�X�B</p>
	 * <p>Design Pattern��1�ł���uCommand Pattern�v�̊ȈՎ����B</p>
	 * 
	 * @author M.Yoneyama
	 * @version 1.0
	 */
	public interface Action {

		/**
		 * <p>�r�W�l�X�E���W�b�N�����s����B</p>
		 * 
		 * @param request HTTP���N�G�X�g�E�I�u�W�F�N�g
		 * @param response HTTP���X�|���X�E�I�u�W�F�N�g
		 * @return �r�W�l�X�E���W�b�N���s��̑J�ڐ�p�X
		 * @throws ServletException
		 * @throws IOException
		 */
		public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
