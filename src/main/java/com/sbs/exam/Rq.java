package com.sbs.exam;

import com.sbs.exam.util.Util;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    @Getter
    private boolean isInvalid = false;
    @Getter
    private String controllerName;
    @Getter
    private String controllerTypeName;
    @Getter
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


    public String getParam(String paramName, String defaultValue) {
        String paramValue = req.getParameter(paramName);

        if (paramValue == null || paramValue.trim().length() == 0) {
            return defaultValue;
        }

        return paramValue;
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

    public void print(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(String str) {
        print(str + "\n");
    }

    public void printf(String format, Object... args) {
        print(Util.f(format, args));
    }


    public void jsp(String jspPath) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + jspPath + ".jsp");

        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void historyBack(String msg) {
      println("<script>");
      printf("alert(%s);\n", msg);
      println("history.back();");
      println("</script>");
    }

    public void replace(String msg, String redirectUri) {
        println("<script>");
        printf("alert('%s');\n", msg);
        printf("location.replace('%s');\n", redirectUri);
        println("</script>");
    }

    public void setAttr(String attrName, Object attrValue) {
        req.setAttribute(attrName, attrValue);
    }
}
