package pl.szczerbiak.kwejk2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.szczerbiak.kwejk2.model.Comment;
import pl.szczerbiak.kwejk2.model.Mem;
import pl.szczerbiak.kwejk2.repository.CategoryRepository;
import pl.szczerbiak.kwejk2.repository.CommentRepository;
import pl.szczerbiak.kwejk2.repository.MemRepository;

import java.util.Optional;

@Controller
public class MemController {

    @Autowired
    private MemRepository memRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/")
    public String show(ModelMap modelMap) {
        modelMap.addAttribute("mems", memRepository.findAll());
        return "index";
    }

    @GetMapping("/mems/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("mem", new Mem());
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "/mems/add";
    }

    @PostMapping("/mems/add")
    public String save(@ModelAttribute Mem mem) {
        memRepository.save(mem);
        return "redirect:/";
    }

    @GetMapping("mems/{memId}")
    public String mem(@PathVariable Long memId, ModelMap modelMap) {
        Optional<Mem> memOptional = memRepository.findById(memId);
        memOptional.ifPresent(
                mem -> {
                    modelMap.addAttribute("mem", mem);
                });
        return "mems/show";
    }

    @PostMapping("mems/addcomment")
    public String addComment(@RequestParam String commentText, @RequestParam Long memId) {

        Optional<Mem> memOptional = memRepository.findById(memId);
        memOptional.ifPresent(
                mem -> {
                    Comment comment = new Comment();
                    comment.setText(commentText);
                    comment.setMem(mem);
                    commentRepository.save(comment); // database update
                }
        );
        return "redirect:/mems/"+memId;
    }
}
