package jp.co.comnic.javalesson.inventory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * �ｽ奇ｽ難ｽ舌°繧峨�ｮ繝ｪ繧ｯ繧ｨ繧ｹ繝医ｒ蠢�縺壽怙蛻昴↓蜿励￠繧九し繝ｼ繝悶Ξ繝�繝医ヵ繧｡繧､繝ｫ縲�
 * 繝ｪ繧ｯ繧ｨ繧ｹ繝�URL縺後��*.do縲阪�ｮ縺吶∋縺ｦ縺ｮ繝ｪ繧ｯ繧ｨ繧ｹ繝医ｒ蜿励￠莉倥￠縲�驕ｩ蛻�縺ｪ繝薙ず繝阪せ繝ｻ繝ｭ繧ｸ繝�繧ｯ縺ｫ蜃ｦ逅�繧貞ｧ碑ｭｲ縺励�〃iew縺ｫ霆｢騾√☆繧九��
 * </p>
 * 
 */
@WebServlet("*.do") // 縲�.do縲阪′莉倥￥縺吶∋縺ｦ縺ｮ繝ｪ繧ｯ繧ｨ繧ｹ繝医ｒ蜿励￠莉倥￠繧�
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * <p></p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// ActionFactoryのgetActionにサーブレットパスを渡すことで適切なアクションクラスのインスタンスを生成する
		Action action = ActionFactory.getAction(request.getServletPath());
		// 適切なアクションに値を渡し、フォワードパスを得る
		String forwardPath = action.execute(request, response);
		
		// フォワードパスがnullでない場合はフォワードする
		if (forwardPath != null) {
			
			request.getRequestDispatcher(forwardPath).forward(request, response);
//			System.out.println("bbb");
		}
	}
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
}
