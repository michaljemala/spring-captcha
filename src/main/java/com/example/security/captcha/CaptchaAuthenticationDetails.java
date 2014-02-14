package com.example.security.captcha;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import nl.captcha.Captcha;

import org.springframework.web.util.WebUtils;

public class CaptchaAuthenticationDetails implements Serializable {

	private static final long serialVersionUID = 8047091036777813803L;

	private final String answer;
	private final Captcha captcha;

	public CaptchaAuthenticationDetails(HttpServletRequest req) {
		this.answer = req.getParameter("j_captcha");
		this.captcha = (Captcha) WebUtils.getSessionAttribute(req, "captcha");
	}

	public String getAnswer() {
		return answer;
	}

	public Captcha getCaptcha() {
		return captcha;
	}

}
