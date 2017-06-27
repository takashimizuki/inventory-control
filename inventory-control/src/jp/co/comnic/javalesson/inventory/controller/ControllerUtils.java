package jp.co.comnic.javalesson.inventory.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

import jp.co.comnic.javalesson.inventory.control.dao.AccountDao;
import jp.co.comnic.javalesson.inventory.control.dao.DaoException;
import jp.co.comnic.javalesson.inventory.control.entity.Account;

/**
 * <p>コントローラーの処理に関連する便利なメソッドをまとめたユーティリティ・クラス。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class ControllerUtils {

	/**
	 * <p>渡されたサーブレット・パスからエンティティの完全修飾クラス名を生成して返す。</p>
	 * <p>
	 * 想定されるサーブレットパスと完全一致の場合のみ正しいクラスネームを返します。
	 * 一致しない場合は、仮としてアザーを返す。
	 * </p>
	 * 
	 * @param servletPath リクエストURLに含まれるサーブレット・パス 
	 * @return エンティティ・クラスの完全修飾クラス名
	 */
	public static String getFullyQualifiedClassName(String servletPath) {
		
		String className = "";
		
		if("/new-account.do".equals(servletPath)){
			className = "Account";
		} else if("/new.do".equals(servletPath) || "/edit.do".equals(servletPath)){
			className = "Purchase";
		} else{
			className = "other";
		}
		String packageName = "jp.co.comnic.javalesson.inventory.control.entity.";

		return packageName + className;
	}

	/**
	 * <p>リクエスト・パラメーターの値からエンティティ・オブジェクトを生成して返す。</p>
	 * 
	 * @param request 
	 * @param entity
	 */
	public static void populateEntity(HttpServletRequest request, Object entity) {

		// リクエスト・パラメーターの集合をMapオブジェクトとして取得
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		// Map<String, String>に変換
		Map<String, String> propertyMap = new HashMap<>();
		for (String key : parameterMap.keySet()) {
			propertyMap.put(key, parameterMap.get(key)[0]);
			System.out.println(parameterMap.get(key)[0]);
		}

		try {

			// 日付形式への対応
			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("yyyy-MM-dd");
			
			// コンバーターの登録
			ConvertUtils.register(dateConverter, java.util.Date.class);
//			ConvertUtils.register(new AccountConverter(), Account.class);
			//accountの処理には不要?
			
			// Apache Commons ProjectのBeanUtilsを使用して
			// Mapオブジェクトからエンティティ・オブジェクトへ値をセット
			BeanUtils.populate(entity, propertyMap);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * リクエスト・パラメーターとして送られてきたString型のdept_idからDepartmentオブジェクト
	 * に変換するBeanUtils用カスタム・コンバーター
	 * 
	 * accountの処理には不要?
	 */
//	private static class AccountConverter implements Converter {
//
//		@Override
//		public <T> T convert(Class<T> accountClass, Object value) {
//			
//			T account = null;	
//			
//			try {
//				
//				account = accountClass.cast(
//						new AccountDao().findById((String)value));
//				
//			} catch (NumberFormatException | DaoException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return account;
//		}
//	}
	
	/**
	 * <p>データベースに関連するエラー・メッセージから最も重要な短いメッセージを取り出して返す。</p>
	 * 
	 * @param e 例外オブジェクト
	 * @return 例外オブジェクトから取り出した簡略なメッセージ
	 */
	public static String getShortMessage(Throwable e) {

		String errorMessage = e.getCause().getMessage().split(":")[3];
		
		if (errorMessage.endsWith("Error Code")) {
			errorMessage = errorMessage.replaceAll("Error Code", "");
		}
		
		return errorMessage;
	}
}
