package br.com.zup.CriacaoDePropostas.controller.validacao;

import javax.servlet.http.HttpServletRequest;

public class GetIp {

	public static String getIpAdress(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null) {
			ipAddress = request.getHeader("X_FORWARDED_FOR");
			if(ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
		}
		return ipAddress;
	}
	
	public static String getAgent(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
		return userAgent;
	}
	
	
}
