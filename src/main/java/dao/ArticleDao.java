package dao;

import com.sbs.exam.util.DBUtil;
import com.sbs.exam.util.SecSql;
import dto.Article;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleDao {
  private Connection con;
  public ArticleDao(Connection con) {
    this.con = con;
  }

  public int getTotalCount() {
    SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
    sql.append("FROM article");

    int totalCount = DBUtil.selectRowIntValue(con, sql);

    return totalCount;
  }

  public List<Article> getArticles(int itemInAPage, int limitFrom) {

    SecSql sql = new SecSql();
    sql.append("SELECT * FROM article ORDER BY id DESC LIMIT ?, ?", limitFrom, itemInAPage);

    List<Map<String, Object>> articleRows = DBUtil.selectRows(con, sql);

    List<Article> articles = new ArrayList<>();

    for( Map<String, Object> articleRow : articleRows) {
      articles.add(new Article(articleRow));
    }

    return articles;
  }

  public int write(String title, String body, int loginedMemberId) {
    SecSql sql = SecSql.from("INSERT INTO article(regDate, updateDate, title, `body`, memberId");
    sql.append("VALUES (NOW(), NOW(), ?, ?, ?)",title,body, loginedMemberId );

    int id = DBUtil.insert(con, sql);

    return id;
  }

  public Article getForPrintArticleById(int id) {
    SecSql sql = SecSql.from("SELECT * FROM article");
    sql.append("WHERE id = ?", id);

    return new Article(DBUtil.selectRow(con, sql));
  }
}