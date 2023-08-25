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

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

  private CategoryDao categoryDao;
  private ArticleDao articleDao;

  @GetMapping("/add")
  public String showForm(Model model) {
    model.addAttribute("category", new Category());
    return "category/add-category-form";
  }

  @PostMapping("/add")
  public String saveForm(Category category) {
    categoryDao.save(category);
    return "redirect:/category/list";
  }

  @GetMapping("/list")
  public String getAll(Model model) {
    model.addAttribute("categories", categoryDao.findAll());
    return "category/category-list";
  }

  @GetMapping("/update/{id}")
  public String updateForm(Model model, @PathVariable Integer id) {
    Category category = categoryDao.findById(id);
    model.addAttribute("category", category);
    return "category/update-category-form";
  }

  @PostMapping("/update/{id}")
  public String update(Category category, BindingResult result) {
    if (result.hasErrors()) {
      return "category/update-category-form";
    }
    categoryDao.update(category);
    return "redirect:/category/list";
  }

  @GetMapping("/remove/{id}")
  public String removeForm(Model model, @PathVariable Integer id) {
    model.addAttribute("categoryId", id);
    return "category/confirm-remove-category";
  }

  @GetMapping("/remove/{id}/confirmed")
  public String removeConfirmed(@PathVariable Integer id) {
    Category category = categoryDao.findById(id);
    categoryDao.delete(category);
    return "redirect:/category/list";
  }

  @ModelAttribute("articles")
  public List<Article> getArticles() {
    return articleDao.findAll();
  }
}
