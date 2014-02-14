package com.example.web;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.security.captcha.CaptchaGenerator;
import com.example.security.captcha.CaptchaUtils;

@Controller
@SessionAttributes("counter")
public class LoginController {

	@Autowired
	private CaptchaGenerator captchaGenerator;
	
	private static final int MAX_NOCAPTCHA_TRIES = 3;

//	@ModelAttribute("captcha")
//	public Captcha captcha() {
//		return captchaGenerator.createCaptcha(200, 50);
//	}

	@ModelAttribute("counter")
	public AtomicInteger failureCounter() {
		return new AtomicInteger(0);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpSession session) {
		AtomicInteger counter = (AtomicInteger) model.get("counter");
		if (counter.intValue() >= MAX_NOCAPTCHA_TRIES) {
			Captcha captcha = captchaGenerator.createCaptcha(200, 50);
			session.setAttribute("captcha", captcha);
			model.addAttribute("captchaEnc", CaptchaUtils.encodeBase64(captcha));
		}
		return "login";
	}

}