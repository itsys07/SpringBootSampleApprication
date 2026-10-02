package com.example.demo.user.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.user.domain.model.MUser;
import com.example.demo.user.domain.service.UserService;
import com.example.demo.user.form.UserDetailForm;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserDetailController {
	
	private final UserService userService;
	private final ModelMapper modelMapper;
	
	/** ユーザー詳細画面を表示 */
	@GetMapping("/detail/{userId}")
	public String getUser(UserDetailForm form, Model model, 
			@PathVariable("userId") String userId) {
		
		//ユーザー1件取得
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);//取得した行からパスワードを除外（セキュリティ）
		//MUserをformに変換
		form = modelMapper.map(user, UserDetailForm.class);
		//Modelに登録
		model.addAttribute("userDetailForm", form);
		//ユーザー詳細画面を表示
		return "user/detail";
	}

}
