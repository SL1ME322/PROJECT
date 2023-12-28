package com.example.projectup.controllers;

import com.example.projectup.models.NotificationModel;
import com.example.projectup.models.UserModel;
import com.example.projectup.repositories.NotificationRepository;
import com.example.projectup.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/estates")
public class NotificationController {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository; ;


    @Autowired
    public NotificationController(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }


    @PostMapping("/notifications/{notificationId}")
    public String updateNotification(@Valid NotificationModel notificationModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/estates";
        }
        notificationRepository.save(notificationModel);
        model.addAttribute("notifications", notificationRepository.findAll());
        return "redirect:/estates";
    }
    //@PatchMapping("/libraries/{libraryId}")
    //public String updateLibrary(@ModelAttribute("library") LibraryModel library, @PathVariable("libraryId") int libraryId) {
    //    libraryDao.update(libraryId, library);
    //    return "redirect:/books";
    //}


    @GetMapping("/notifications/{notificationId}/notificationEdit")
    public String notificationEdit(Model model, @PathVariable("notificationId") int libraryId) {
        NotificationModel notificationModel = notificationRepository.findById((long) libraryId).orElseThrow(()
                -> new IllegalArgumentException("Invalid customer Id:" + libraryId));
        model.addAttribute("notification", notificationModel);
        return "estates/notification/editNotification";
    }

    //
    @GetMapping("/notifications/{notificationId}")
    public String showNotification(@PathVariable("notificationId") int libraryId, Model model) {

        model.addAttribute("notification", notificationRepository.findById(libraryId));
        return "estates/notification/showNotification";
    }

    //
    @PostMapping("/createNotification")
    public String createNotification(@ModelAttribute("notification") NotificationModel notification, Model model) {
        Iterable<UserModel> userModels = userRepository.findAll();
        notificationRepository.save(notification);
        model.addAttribute("users", userModels);
        model.addAttribute("notifications", notificationRepository.findAll());
        return "redirect:/estates";
    }


    @PostMapping("/delete/notification/{notificationId}")
    public String delete(@PathVariable("notificationId") int id, Model model) {
        NotificationModel notificationModel = notificationRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        notificationRepository.delete(notificationModel);
        model.addAttribute("notifications", notificationRepository.findAll());
        return "redirect:/books";
    }

    @GetMapping("/newNotification")
    public String newNotification(@ModelAttribute("notification") NotificationModel notificationModel, Model model) {
        Iterable<UserModel> userModels = userRepository.findAll();
        model.addAttribute("users", userModels);
        model.addAttribute("notifications",  notificationModel);
        return "estates/notification/newNotification";
    }
}
