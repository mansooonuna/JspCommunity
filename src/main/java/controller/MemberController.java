package controller;

import dto.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class MemberController {

  private HttpServletRequest req;
  private HttpServletResponse resp;
  private Connection conn;
  private MemberService memberService;

  public MemberController(HttpServletRequest req, HttpServletResponse resp, Connection conn) {
    this.req = req;
    this.resp = resp;

    memberService = new MemberService(conn);
  }

}
