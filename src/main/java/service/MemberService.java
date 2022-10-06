package service;

import com.sbs.exam.util.DBUtil;
import com.sbs.exam.util.SecSql;
import dao.MemberDao;


import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class MemberService {
  private MemberDao memberdao;

  public MemberService(Connection conn) {
    this.memberdao = new MemberDao(conn);
  }

}
