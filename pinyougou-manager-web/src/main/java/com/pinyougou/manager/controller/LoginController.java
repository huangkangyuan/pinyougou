package com.pinyougou.manager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/showName")
	public Map getUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		Map map = new HashMap<>();
		map.put("loginName", username);
		map.put("loginTime",new Date().toString());
		return map;
	}

}
