package com.souleaf.spring.member.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.souleaf.spring.member.util.MailUtils;

@Service("mss")
public class MailSendService {
	@Autowired
	private JavaMailSenderImpl mailSender;
	private int size;

	// 인증키 생성
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}

	// 인증코드 난수 발생
	private String getAuthCode() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int num = 0;

		while (buffer.length() < size) {
			num = random.nextInt(10);
			buffer.append(num);
		}

		return buffer.toString();
	}

	// 인증메일 보내기
	public String sendAuthMail(String email) {
		// 6자리 난수 인증번호 생성
		String authKey = getKey(6);

		// 인증메일 보내기
		try {
			MailUtils sendMail = new MailUtils(mailSender);
			sendMail.setSubject("[SOULEAF]이메일 인증");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
					.append("<p>아래 인증번호를 현재 창에 입력 시 이메일 인증이 완료됩니다.</p>")
					.append("<p>인증번호 : "+authKey+" </p>").toString());
			sendMail.setFrom("khprojectfinal@gmail.com", "(주)SOULEAF");
			sendMail.setTo(email);
			sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return authKey;
	}
}
