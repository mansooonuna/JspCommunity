package Servlet.Member;

import com.sbs.exam.Config;
import com.sbs.exam.util.DBUtil;
import com.sbs.exam.util.SecSql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/member/doJoin")
public class MemberDoJoinServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset-utf-8");
    String driverName = Config.getDriverClassName();
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      System.out.printf("[ClassNotFoundException 예외, %s]", e.getMessage());
      resp.getWriter().append("DB 드라이버 클래스 로딩 실패");
      return;
    }

    // DB 연결
    Connection con = null;
    try {
      con = DriverManager.getConnection(Config.getDBUrl(), Config.getDBId(), Config.getDBPw());
      String loginId = req.getParameter("loginId");
      String loginPw = req.getParameter("loginPw");
      String name = req.getParameter("name");

      SecSql sql = new SecSql();
      sql.append("SELECT COUNT(*) AS cnt FROM `member` WHERE loginId = ?", loginId);

      boolean isAvailableLoginId = DBUtil.selectRowIntValue(con, sql) == 0;

      if(isAvailableLoginId == false) {
        resp.getWriter().append(String.format("<script>alert('%s (은)는 이미 사용중인 아이디입니다.'); history.back();</script>", loginId));
        return;
      }

      sql = SecSql.from("INSERT INTO `member`(regDate, updateDate, loginId, loginPw, `name`)");
      sql.append("VALUES (NOW(), NOW(), ?, ?, ?)", loginId, loginPw, name);

      DBUtil.insert(con, sql);
      resp.getWriter().append("<script> alert('회원가입 완료!'); location.replace('../home/main'); </script>");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}