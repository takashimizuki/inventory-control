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
		// 繝ｪ繧ｯ繧ｨ繧ｹ繝�URL縺九ｉ驕ｩ蛻�縺ｪAction繧ｪ繝悶ず繧ｧ繧ｯ繝�(繝薙ず繝阪せ繝ｻ繝ｭ繧ｸ繝�繧ｯ縺ｮ螳溯｡後ｒ繧ｫ繝励そ繝ｫ蛹悶☆繧九が繝悶ず繧ｧ繧ｯ繝�)繧貞叙蠕�
		Action action = ActionFactory.getAction(request.getServletPath());
		// Action繧貞ｮ溯｡後＠縺ｦ縲∬ｻ｢騾∝��View縺ｮ繝代せ繧貞叙蠕�
		String forwardPath = action.execute(request, response);
		
		// Action縺ｮ螳溯｣�蜈医〒sendRedirect縺悟ｮ溯｡後＆繧後※縺�繧句�ｴ蜷医↓縺ｯ繝ｬ繧ｹ繝昴Φ繧ｹ縺後☆縺ｧ縺ｫ霑秘�√＆繧後※縺�繧九◆繧］ull縺瑚ｿ斐ｋ
		if (forwardPath != null) { // 繝ｬ繧ｹ繝昴Φ繧ｹ縺後∪縺�霑秘�√＆繧後※縺�縺ｪ縺代ｌ縺ｰ
			// 驕ｩ蛻�縺ｪView縺ｫ霆｢騾�
			request.getRequestDispatcher(forwardPath).forward(request, response);
			System.out.println("bbb");
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
