package com.dcmd.common.core.dcit;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWT2TokenInfo {

	public static String getUsernameByToken() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            throw new IllegalStateException("当前线程中不存在 Request 上下文");
        }
        HttpServletRequest req = attrs.getRequest();
		String authorization =  req.getHeader(CommonConstant.REQ_HEADER);
		Key KEY = new SecretKeySpec(CommonConstant.SIGN_KEY.getBytes(),
				SignatureAlgorithm.HS512.getJcaName());
		String compactJws = StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(compactJws);
//		JwsHeader header = claimsJws.getHeader();
		Claims body = claimsJws.getBody();
		String username = body.get("user_name", String.class);
		return username;
	}
}
