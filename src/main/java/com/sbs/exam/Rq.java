package com.sbs.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
  private HttpServletRequest req;
  private HttpServletResponse resp;
  private boolean isInvalid = false;
  private String controllerName;
  private String controllerTypeName;
  private String actionMethodName;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {

    try {
      req.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset-utf-8");

    this.req = req;
    this.resp = resp;

    String requestUri = req.getRequestURI();
    String[] requestUriBits = requestUri.split("/");

    int minBitsCount = 4;

    if (requestUriBits.length < minBitsCount) {
      isInvalid = true;
      return;
    }

    this.controllerTypeName = requestUriBits[1];
    this.controllerName = requestUriBits[2];
    this.actionMethodName = requestUriBits[3];
  }


  public int getIntParam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }

  }

  public void appendBody(String str) {
    try {
      resp.getWriter().append(str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public HttpServletRequest getReq() {
    return req;
  }
  public boolean getIsInvalid() {
    return isInvalid;
  }

  public String getControllerName() {
    return controllerName;
  }
  public String getControllerTypeName() {
    return controllerTypeName;
  }

  public String getActionMethodName() {
    return actionMethodName;
  }


  public void jsp(String jspPath) {
    System.out.println(jspPath);
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + jspPath + ".jsp");

    try {
      requestDispatcher.forward(req,resp);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
