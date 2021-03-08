package com.app.api.service.util;

import org.springframework.stereotype.Component;

@Component
public class UserCategoryServiceUtil {
	
	public String convertCategoryNameToStandard(String category) {
		category.substring(0, 1).toUpperCase();
		category.substring(2, category.length());
		return category;
	}
	
	public boolean isCategoryAlreadyRegisteredToCertainUser(String category) {
		return true;
	}
}
