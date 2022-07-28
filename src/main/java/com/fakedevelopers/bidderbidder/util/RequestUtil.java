package com.fakedevelopers.bidderbidder.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpHeaders;

public class RequestUtil {
  // Request 메세지를 검증하고, 토큰 값을 가져온다.

  private RequestUtil() {
    throw new IllegalAccessError("Utility Class는 인스턴스를 생성할 수 없습니다.");
  }

  public static String getAuthorizationToken(String header) {
    // Authorization: [Bearer <token>]
    // @Param: [Bearer <token>]
    if (header == null || !header.startsWith("Bearer ")) {
      throw new IllegalArgumentException("유효하지 않은 토큰");
    }

    String[] parts = header.split(" ");
    if (parts.length != 2) {
      throw new IllegalArgumentException("유효하지 않은 토큰");
    }
    // 토큰 값을 리턴
    return parts[1];
  }

  public static String getAuthorizationToken(HttpServletRequest request) {
    return getAuthorizationToken(request.getHeader(HttpHeaders.AUTHORIZATION));
  }
}
