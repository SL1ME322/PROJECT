package com.example.projectup.controllers;

import com.example.projectup.models.TagModel;
import com.example.projectup.repositories.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estates")
public class TagController {

    private final TagRepository tagRepository;

    @Autowired

    public TagController(TagRepository tagRepository ) {
        this.tagRepository = tagRepository;

    }


    //@PatchMapping("/reviews/{reviewId}")
    //public String updateReview(@ModelAttribute("review") ReviewModel review, @PathVariable("reviewId") int reviewId) {
    //    reviewDao.update(reviewId, review);
    //    return "redirect:/books";
    //}
//
    //@GetMapping("/reviews/{reviewId}/reviewEdit")
    //public String reviewEdit(Model model, @PathVariable("reviewId") int reviewId) {
    //    model.addAttribute("review", reviewDao.get(reviewId));
    //    return "books/reviewEdit";
    //}
//
    @PostMapping("/tags/{tagId}")
    public String updateTag(@Valid TagModel tagModel, BindingResult result, Model model)     {

        if (result.hasErrors()) {

            return "redirect:/estates";
        }
        tagRepository.save(tagModel);
        model.addAttribute("tags", tagRepository.findAll());
        return "redirect:/estates";


    }

    @GetMapping("/tags/{tagId}/tagEdit")
    public String tagEdit(Model model, @PathVariable("tagId") int tagId) {
        TagModel tagModel = tagRepository.findById((long) tagId).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + tagId));
        model.addAttribute("tag", tagModel);
        return "estates/tag/editTag";
    }
    @GetMapping("/tags/{tagId}")
    public String showTag(@PathVariable("tagId") int reviewId, Model model) {
        model.addAttribute("tag", tagRepository.findById(reviewId));
        return "estates/tag/showTag";
    }
    //
    @PostMapping("/createTag")
    public String createTag(@ModelAttribute("tag") TagModel tag, Model model  ) {
        tagRepository.save(tag);

        model.addAttribute("tags", tagRepository.findAll());
        //model.addAttribute("authors", authorRepository.findAll());
        //model.addAttribute("books", bookRepository.findAll());
        return "redirect:/estates";
    }
//


    @DeleteMapping("/tag/{id}")
    public String deleteReview(@PathVariable("id") int tagId, Model model) {

        TagModel reviewModel = tagRepository.findById((long) tagId).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + tagId));
        tagRepository.delete(reviewModel);
        model.addAttribute("tags ", tagRepository.findAll());
        return "redirect:/estates";
    }

    @PostMapping("delete/tag/{tagId}")
    public String delete(@PathVariable("tagId") int id    , Model model) {
        TagModel tagModel = tagRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        tagRepository.delete(tagModel);
        model.addAttribute("tags", tagRepository.findAll());
        return "redirect:/estates";
    }
    @GetMapping("/newTag")

    public String newTag(@ModelAttribute("tag") TagModel tagModel, Model author) {
        //Iterable<AuthorModel> authorModel = authorRepository.findAll();
        //Iterable<BookModel> bookModels = bookRepository.findAll();
        //author.addAttribute("authors", authorModel);
        //author.addAttribute("books", bookModels);
        return "estates/tag/newTag";
    }
}

