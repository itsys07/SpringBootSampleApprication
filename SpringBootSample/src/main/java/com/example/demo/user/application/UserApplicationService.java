package com.example.demo.user.application;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserApplicationService {
	
	private final MessageSource messageSource;
	
	/** 性別のMapを生成 */
	public Map<String,Integer> getGenderMap(){
		Map<String,Integer> genderMap = new LinkedHashMap<>();
		String male = messageSource.getMessage("male",null,null);
		String famale = messageSource.getMessage("famale",null,null);
		genderMap.put(male, 1);
		genderMap.put(famale, 2);
		return genderMap;
	}
}
