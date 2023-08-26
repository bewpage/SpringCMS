package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {
  private ArticleDao articleDao;
  private AuthorDao authorDao;
  private CategoryDao categoryDao;

  @GetMapping("/add")
  public String addForm(Model model) {
    model.addAttribute("article", new Article());
    return "article/add-article-form";
  }

  @PostMapping("/add")
  public String saveForm(Article article) {
    articleDao.save(article);
    return "redirect:/article/list";
  }

  @GetMapping("/list")
  public String getAll(Model model) {
    model.addAttribute("articles", articleDao.findAll());
    return "article/article-list";
  }

  @GetMapping("/details")
  public String getArticle(Model model, @RequestParam Long id) {
    Article article = articleDao.findById(id);

    LocalDateTime created = article.getCreated();
    LocalDateTime updated = article.getUpdated();

    // format created date
    DateTimeFormatter formatterCreated = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedCreated = created.format(formatterCreated);

    // format updated date
    DateTimeFormatter formatterUpdated = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedUpdated = updated.format(formatterUpdated);

    // add formatted updated date to model if updated date is not null
    if (updated != null) {
      model.addAttribute("formattedUpdated", formattedUpdated);
    }
    // add formatted created date to model
    model.addAttribute("formattedCreated", formattedCreated);
    model.addAttribute("article", article);


    return "article/article-details";
  }

  @GetMapping("/update/{id}")
  public String updateForm(Model model, @PathVariable Long id) {
    Article article = articleDao.findById(id);
    model.addAttribute("article", article);
    return "article/update-article-form";
  }

  @PostMapping("/update/{id}")
  public String update(Article article, BindingResult result) {
    if (result.hasErrors()) {
      return "article/update-article-form";
    }
    articleDao.update(article);
    return "redirect:/article/list";
  }

  @GetMapping("/remove/{id}")
  public String removeNotConfirmed(@PathVariable Long id, Model model) {
    model.addAttribute("articleId", id);
    return "article/confirm-remove-article";
  }

  @GetMapping("/remove/{id}/confirmed")
  public String remove(@PathVariable Long id) {
    Article article = articleDao.findById(id);
    articleDao.delete(article);
    return "redirect:/article/list";
  }

  @ModelAttribute("categories")
  public List<Category> getCategories() {
    return categoryDao.findAll();
  }

  @ModelAttribute("authors")
  public List<Author> getAuthors() {
    return authorDao.findAll();
  }
}
