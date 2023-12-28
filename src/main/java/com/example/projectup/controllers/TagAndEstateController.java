package com.example.projectup.controllers;

import com.example.projectup.models.*;
import com.example.projectup.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estates")
public class TagAndEstateController {
    private final TagRepository tagRepository;
    private final EstateRepository estateRepository;
    private final TagAndEstateRepository tagAndEstateRepository;

    @Autowired
    public TagAndEstateController(TagRepository tagRepository,
                                   EstateRepository estateRepository, TagAndEstateRepository tagAndEstateRepository) {
        this.tagRepository = tagRepository;
        this.estateRepository = estateRepository;
        this.tagAndEstateRepository = tagAndEstateRepository;
    }


   // @PostMapping("/notifications/{notificationId}")
   // public String updateNotification(@Valid NotificationModel notificationModel, BindingResult result, Model model) {
   //     if (result.hasErrors()) {
   //         return "redirect:/estates";
   //     }
   //     notificationRepository.save(notificationModel);
   //     model.addAttribute("notifications", notificationRepository.findAll());
   //     return "redirect:/estates";
   // }
    //@PatchMapping("/libraries/{libraryId}")
    //public String updateLibrary(@ModelAttribute("library") LibraryModel library, @PathVariable("libraryId") int libraryId) {
    //    libraryDao.update(libraryId, library);
    //    return "redirect:/books";
    //}


    //@GetMapping("/notifications/{notificationId}/notificationEdit")
    //public String notificationEdit(Model model, @PathVariable("notificationId") int libraryId) {
    //    NotificationModel notificationModel = notificationRepository.findById((long) libraryId).orElseThrow(()
    //            -> new IllegalArgumentException("Invalid customer Id:" + libraryId));
    //    model.addAttribute("notification", notificationModel);
    //    return "estates/notification/editNotification";
    //}

    //
   // @GetMapping("/notifications/{notificationId}")
   // public String showNotification(@PathVariable("notificationId") int libraryId, Model model) {
//
   //     model.addAttribute("notification", notificationRepository.findById(libraryId));
   //     return "estates/notification/showNotification";
   // }

    //
    @PostMapping("/createTagAndEstate")
    public String createTagAndEstate(@ModelAttribute("tagAndEstate") TagAndEstateModel tagAndEstateModel, Model model) {
        Iterable<TagModel> tagModel = tagRepository.findAll();
        Iterable<EstateModel> estateModels = estateRepository.findAll();
        tagAndEstateRepository.save(tagAndEstateModel);
        model.addAttribute("tags", tagModel);
        model.addAttribute("estates", estateModels);
        return "redirect:/estates";
    }


   //@PostMapping("/delete/notification/{notificationId}")
   //public String delete(@PathVariable("notificationId") int id, Model model) {
   //    NotificationModel notificationModel = notificationRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
   //    notificationRepository.delete(notificationModel);
   //    model.addAttribute("notifications", notificationRepository.findAll());
   //    return "redirect:/books";
   //}

    @GetMapping("/newTagAndEstate")
    public String newTagAndEstate(@ModelAttribute("tagAndEstate") TagAndEstateModel tagAndEstateModel, Model model) {
        Iterable<TagModel> tags = tagRepository.findAll();
        Iterable<EstateModel> estateModels = estateRepository.findAll();

        model.addAttribute("tags", tags);
        model.addAttribute("estates", estateModels);
        return "estates/tagAndEstate/newTagAndEstate";
    }
}
