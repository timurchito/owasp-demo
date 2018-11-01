package com.epam.teemo.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieReceiveController
{

	@RequestMapping(value = "/xss_endpoint", method = RequestMethod.GET)
	public String getCookies(@RequestParam("cookies") String cookies, HttpServletResponse response) {
		System.out.println(cookies);
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

}
