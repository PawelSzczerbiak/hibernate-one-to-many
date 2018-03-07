package pl.szczerbiak.kwejk2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szczerbiak.kwejk2.model.Category;
import pl.szczerbiak.kwejk2.repository.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories/add")
    public String add(ModelMap modelMap){
        modelMap.addAttribute("category",new Category());
        return "/categories/add";
    }

    @PostMapping("/categories/add")
    public String save(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/";
    }
}
