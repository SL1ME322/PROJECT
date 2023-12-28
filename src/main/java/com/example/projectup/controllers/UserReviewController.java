package com.example.projectup.controllers;

import com.example.projectup.models.NotificationModel;
import com.example.projectup.models.UserModel;
import com.example.projectup.models.UserReviewModel;
import com.example.projectup.repositories.NotificationRepository;
import com.example.projectup.repositories.UserRepository;
import com.example.projectup.repositories.UserReviewRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estates")
public class UserReviewController {

    private final UserRepository userRepository; ;
    private final UserReviewRepository userReviewRepository; ;

    @Autowired
    public UserReviewController(
                                UserRepository userRepository,
                                UserReviewRepository userReviewRepository) {

        this.userRepository = userRepository;
        this.userReviewRepository = userReviewRepository;
    }


    //@PostMapping("/notifications/{notificationId}")
    //public String updateNotification(@Valid NotificationModel notificationModel, BindingResult result, Model model) {
    //    if (result.hasErrors()) {
    //        return "redirect:/estates";
    //    }
    //    notificationRepository.save(notificationModel);
    //    model.addAttribute("notifications", notificationRepository.findAll());
    //    return "redirect:/estates";
    //}
    ////@PatchMapping("/libraries/{libraryId}")
    ////public String updateLibrary(@ModelAttribute("library") LibraryModel library, @PathVariable("libraryId") int libraryId) {
    ////    libraryDao.update(libraryId, library);
    ////    return "redirect:/books";
    ////}
//
//
    //@GetMapping("/notifications/{notificationId}/notificationEdit")
    //public String notificationEdit(Model model, @PathVariable("notificationId") int libraryId) {
    //    NotificationModel notificationModel = notificationRepository.findById((long) libraryId).orElseThrow(()
    //            -> new IllegalArgumentException("Invalid customer Id:" + libraryId));
    //    model.addAttribute("notification", notificationModel);
    //    return "estates/notification/editNotification";
    //}
//
    ////
  @GetMapping("/userReviews/{userReviewId}")
  public String showNotification(@PathVariable("userReviewId") Long libraryId, Model model) {

      model.addAttribute("userReview", userReviewRepository.findById(libraryId));
      return "estates/userReview/showUserReview";
  }

    //
    @PostMapping("/createUserReview")
    public String createUserReview(@ModelAttribute("userReview") UserReviewModel userReviewModel, Model model) {
        Iterable<UserModel> userModels = userRepository.findAll();
        userReviewRepository.save(userReviewModel);
        model.addAttribute("users", userModels);

        return "redirect:/estates";
    }


    @PostMapping("/delete/userReview/{userReviewId}")
    public String delete(@PathVariable("userReviewId") int id, Model model) {
        UserReviewModel userReviewModel = userReviewRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        userReviewRepository.delete(userReviewModel);
        model.addAttribute("userReviews", userReviewRepository.findAll());
        return "redirect:/estates";
    }

    @GetMapping("/newUserReview")
    public String newNotification(@ModelAttribute("userReview") UserReviewModel userReviewModel, Model model) {
        Iterable<UserModel> userModels = userRepository.findAll();
        model.addAttribute("users", userModels);
        model.addAttribute("userReviews",  userReviewModel);
        return "estates/userReview/newUserReview";
    }
}