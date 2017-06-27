package jp.co.comnic.javalesson.inventory.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * <p>Action�̎����N���X�̃C���X�^���X�𐶐����ĕԂ��t�@�N�g���[�B</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
@WebListener // ���X�i�[�̓o�^
public class ActionFactory implements ServletContextListener {

	// web.xml�ɋL�q���ꂽcontext-param�𗘗p���邽�߂ɕK�v
	private static ServletContext context;
	
	public static Action getAction(String servletPath) throws ServletException {
		
		Action action = null;
		
		// �����œn���ꂽServlet�p�X�ɑΉ�����Action�̎����N���X�����擾
		String actionClassName = context.getInitParameter(servletPath);
		
		try {
			// �擾����Action�̎����N���X������C���X�^���X�𐶐�
			action = (Action)Class.forName(actionClassName).newInstance();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		// ��������Action�̎����N���X�̃C���X�^���X��Ԃ�
		return action;
	}
	
	/* (non-Javadoc)
	 * ServletContextListener�C���^�[�t�F�C�X��implements�����N���X��contextInitialized���\�b�h��
	 * �R���e�i�̋N���������I�ɌĂяo�����
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// �R���e�i�N������ServletContext�I�u�W�F�N�g���󂯎���ăt�B�[���h�ɃZ�b�g
		context = sce.getServletContext();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Not implements
	}
}

