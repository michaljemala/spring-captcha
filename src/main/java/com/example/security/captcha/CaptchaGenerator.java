package com.example.security.captcha;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.BackgroundProducer;
import nl.captcha.backgrounds.TransparentBackgroundProducer;
import nl.captcha.gimpy.GimpyRenderer;
import nl.captcha.gimpy.RippleGimpyRenderer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.noise.NoiseProducer;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.producer.TextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;
import nl.captcha.text.renderer.WordRenderer;

import org.springframework.beans.factory.InitializingBean;

public class CaptchaGenerator implements InitializingBean {

	private BackgroundProducer backgroundProducer;
	private TextProducer textProducer;
	private WordRenderer wordRenderer;
	private NoiseProducer noiseProducer;
	private GimpyRenderer gimpyRenderer;
	boolean isBorder;

	public Captcha createCaptcha(int width, int height) {
		Captcha.Builder builder = new Captcha.Builder(width, height)
				.addBackground(backgroundProducer)
				.addText(textProducer, wordRenderer)
				.addNoise(noiseProducer);
		
		if (isBorder) {
			builder.addBorder();
		}
		
		return builder.build();
	}

	public void setBackgroundProducer(BackgroundProducer backgroundProducer) {
		this.backgroundProducer = backgroundProducer;
	}

	public void setTextProducer(TextProducer textProducer) {
		this.textProducer = textProducer;
	}

	public void setWordRenderer(WordRenderer wordRenderer) {
		this.wordRenderer = wordRenderer;
	}

	public void setNoiseProducer(NoiseProducer noiseProducer) {
		this.noiseProducer = noiseProducer;
	}

	public void setGimpyRenderer(GimpyRenderer gimpyRenderer) {
		this.gimpyRenderer = gimpyRenderer;
	}
	
	public void setBorder(boolean isBorder) {
		this.isBorder = isBorder;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.backgroundProducer == null) {
			this.backgroundProducer = new TransparentBackgroundProducer();
		}

		if (this.textProducer == null) {
			this.textProducer = new DefaultTextProducer();
		}

		if (this.wordRenderer == null) {
			this.wordRenderer = new DefaultWordRenderer();
		}

		if (this.noiseProducer == null) {
			this.noiseProducer = new CurvedLineNoiseProducer();
		}

		if (this.gimpyRenderer == null) {
			this.gimpyRenderer = new RippleGimpyRenderer();
		}
	}
}
