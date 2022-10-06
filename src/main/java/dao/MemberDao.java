package dao;

import com.sbs.exam.util.DBUtil;
import com.sbs.exam.util.SecSql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberDao {
  private Connection con;
  public MemberDao(Connection con) {
    this.con = con;
  }

}