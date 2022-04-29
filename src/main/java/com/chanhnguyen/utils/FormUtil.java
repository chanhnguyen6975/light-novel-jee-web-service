package com.chanhnguyen.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> c, HttpServletRequest request) {
		T object = null;
		try {
			object = c.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		}
		return object;
	}
}
