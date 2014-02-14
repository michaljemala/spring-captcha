package com.example.security.captcha;

import nl.captcha.Captcha;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CaptchaDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		super.additionalAuthenticationChecks(userDetails, token);

		Object obj = token.getDetails();
		if (!(obj instanceof CaptchaAuthenticationDetails)) {
			throw new InsufficientAuthenticationException(
					"Captcha details not found.");
		}

		CaptchaAuthenticationDetails captchaDetails = (CaptchaAuthenticationDetails) obj;
		Captcha captcha = captchaDetails.getCaptcha();
		if (captcha != null) {
			String expected = captcha.getAnswer();
			String actual = captchaDetails.getAnswer();
			if (!expected.equals(actual)) {
				throw new BadCredentialsException("Captcha does not match.");
			}
		}
	}

}
