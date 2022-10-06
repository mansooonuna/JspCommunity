package controller;

import dto.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ArticleService;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ArticleController {

  private HttpServletRequest req;
  private HttpServletResponse resp;
  private Connection conn;
  private ArticleService articleService;

  public ArticleController(HttpServletRequest req, HttpServletResponse resp, Connection conn) {
    this.req = req;
    this.resp = resp;

    articleService = new ArticleService(conn);
  }

  public void actionList() throws ServletException, IOException {
    int page = 1;
    if(req.getParameter("page") != null ) {
      page = Integer.parseInt(req.getParameter("page"));
    }

    int totalPage = articleService.getPrintListTotalPage();
    List<Article> articles = articleService.getPrintArticleRow(page);

    req.setAttribute("articles", articles);
    req.setAttribute("page", page);
    req.setAttribute("totalPage", totalPage);
    req.getRequestDispatcher("/jsp/article/list.jsp").forward(req, resp);
  }
}
