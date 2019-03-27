package com.pinyougou.shop.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {

	private Date loginTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@RequestMapping("/name")
	public Map<String,Object> getUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		setLoginTime(new Date());
		Map<String,Object> map = new HashMap<>();
		map.put("loginName", username);
		map.put("loginTime", getLoginTime());
		return map;
	}

}
