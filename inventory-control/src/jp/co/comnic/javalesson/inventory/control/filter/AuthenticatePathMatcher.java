package jp.co.comnic.javalesson.inventory.control.filter;

/**
 * <p>ログイン認証のフィルターで使用されるパス・マッチャー</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class AuthenticatePathMatcher {

	public static boolean matches(String path) {

		if (path.matches("/login.*") || 
		    path.matches(".*(.css)|(.js)|(.gif)|(.png)|(.jpg)") ||
		    path.matches("/new-account.*")) {
 
			return true;
		}
		
		return false;
	}
}


