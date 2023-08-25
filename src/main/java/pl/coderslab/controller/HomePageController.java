package pl.coderslab.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

@Controller
@AllArgsConstructor
public class HomePageController {

  private ArticleDao articleDao;

  @GetMapping("/home")
  public String homePage(Model model) {
    List<Article> lastFiveArticles = articleDao.findLastFive();
    model.addAttribute("lastFiveArticles", lastFiveArticles);
    return "/article-list";
  }
}
