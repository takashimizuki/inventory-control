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
import jp.co.comnic.javalesson.inventory.control.dao.FoodDao;
import jp.co.comnic.javalesson.inventory.control.entity.Account;
import jp.co.comnic.javalesson.inventory.control.entity.Food;

public class ControllerUtils {

	public static String getFullyQualifiedClassName(String servletPath) {
		
		String className = "";
		
		if("/new-account.do".equals(servletPath)){
			className = "Account";
		} else if("/new.do".equals(servletPath) || "/edit.do".equals(servletPath)|| "/remove.do".equals(servletPath)){
			className = "Purchase";
		} else{
			className = "other";
		}
		String packageName = "jp.co.comnic.javalesson.inventory.control.entity.";

		return packageName + className;
	}

	public static void populateEntity(HttpServletRequest request, Object entity) {

		Map<String, String[]> parameterMap = request.getParameterMap();
		
		Map<String, String> propertyMap = new HashMap<>();
		
		for (String key : parameterMap.keySet()) {
			propertyMap.put(key, parameterMap.get(key)[0]);
			System.out.println(key);
			System.out.println(parameterMap.get(key)[0]);	
		}
		
		if(request.getAttribute("fdid") != null){
			propertyMap.put("id", null);
			propertyMap.put("email", (String) request.getSession().getAttribute("loginEmail"));
			propertyMap.put("foodsid", Integer.toString((int) request.getAttribute("fdid")));
		}
		
		try {

			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("yyyy-MM-dd");
			
			ConvertUtils.register(dateConverter, java.util.Date.class);
			ConvertUtils.register(new AccountConverter(), Account.class);
			ConvertUtils.register(new FoodConverter(), Food.class);
			
			
			BeanUtils.populate(entity, propertyMap);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class AccountConverter implements Converter {

		@Override
		public <T> T convert(Class<T> accountClass, Object value) {
			
			T account = null;	
			
			try {
				
				account = accountClass.cast(
						new AccountDao().findById((String)value));
				
			} catch (NumberFormatException | DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return account;
		}
	}
	
	private static class FoodConverter implements Converter {

		@Override
		public <T> T convert(Class<T> foodClass, Object value) {
			
			T food = null;
			
			try {
				
				food = foodClass.cast(
						new FoodDao().findById((Integer) value));
				
			} catch (NumberFormatException | DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return food;
		}
	}

	public static String getShortMessage(Throwable e) {

		String errorMessage = e.getCause().getMessage().split(":")[3];
		
		if (errorMessage.endsWith("Error Code")) {
			errorMessage = errorMessage.replaceAll("Error Code", "");
		}
		
		return errorMessage;
	}
}
