package service;

import com.sbs.exam.util.DBUtil;
import com.sbs.exam.util.SecSql;
import dao.ArticleDao;
import dto.Article;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ArticleService {
  private ArticleDao articleDao;

  public ArticleService(Connection conn) {
    this.articleDao = new ArticleDao(conn);
  }

  public int getItemInAPage() {
    return 20;
  }

  public int getPrintListTotalPage() {
    int itemInAPage = getItemInAPage();

    int totalCount = articleDao.getTotalCount();
    int totalPage = (int) Math.ceil((double) totalCount / itemInAPage);
    return totalPage;
  }

  public List<Article> getPrintArticleRow(int page) {
    int itemInAPage = getItemInAPage();
    int limitFrom = (page - 1) * itemInAPage;

    List<Article> articles = articleDao.getArticles(itemInAPage, limitFrom);
    return articles;
  }
}
