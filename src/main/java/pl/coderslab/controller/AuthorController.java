package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.dao.AuthorDao;

import java.util.List;

@Controller
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {

  private AuthorDao authorDao;
  private ArticleDao articleDao;

  @GetMapping("/add")
  public String showForm(Model model) {
    model.addAttribute("author", new Author());
    return "author/add-author-form";
  }

  @PostMapping("/add")
  public String saveForm(Author author) {
    authorDao.save(author);
    return "redirect:/author/list";
  }

  @GetMapping("/list")
  public String getAll(Model model) {
    model.addAttribute("authors", authorDao.findAll());
    return "author/author-list";
  }

  @GetMapping("/update/{id}")
  public String updateForm(Model model, @PathVariable Integer id) {
    Author author = authorDao.findById(id);
    model.addAttribute("author", author);
    return "author/update-author-form";
  }

  @PostMapping("/update/{id}")
  public String update(Author author) {
    authorDao.update(author);
    return "redirect:/author/list";
  }

  @GetMapping("/remove/{id}/confirmed")
  public String remove(@PathVariable Integer id) {
    Author author = authorDao.findById(id);
    authorDao.delete(author);
    return "redirect:/author/list";
  }

  @GetMapping("/remove/{id}")
  public String removeNotConfirmed(@PathVariable Integer id, Model model) {
    model.addAttribute("authorId", id);
    return "author/confirm-remove-author";
  }

  @ModelAttribute("articles")
  public List<Article> getArticles() {
    return articleDao.findAll();
  }
}
