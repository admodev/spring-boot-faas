package com.admodev.faas;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class FaasFilter implements Filter {
  @Override
  public void doFilter( ServletRequest request, ServletResponse response,
    FilterChain chain ) throws IOException, ServletException {
      HttpServletRequest req = (HttpServletRequest) request;
      HttpServletResponse res = (HttpServletResponse) response;

      var nonSecureHeader = req.getHeader("nonsecure");

      if (nonSecureHeader != null) {
        res.getOutputStream().write("{ \"error\": \"SECURITY ERROR!\" }".getBytes());
        return;
      }

      chain.doFilter(request, response);
    }
}
