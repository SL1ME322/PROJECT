package com.example.projectup.controllers;

import com.example.projectup.models.DeclinedAdModel;
import com.example.projectup.models.EstateModel;
import com.example.projectup.models.UserModel;
import com.example.projectup.repositories.DeclinedAdRepository;
import com.example.projectup.repositories.EstateRepository;
import com.example.projectup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estates")
public class DeniedEstateController {
    private final DeclinedAdRepository declinedAdRepository;

    private final EstateRepository estateRepository;
    private final UserRepository userRepository;

    @Autowired
    public DeniedEstateController(DeclinedAdRepository declinedAdRepository, EstateRepository estateRepository, UserRepository userRepository) {
        this.declinedAdRepository = declinedAdRepository;
        this.estateRepository = estateRepository;
    this.userRepository = userRepository;
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
    @GetMapping("/declinedAds/{declinedAdId}")
    public String showNotification(@PathVariable("declinedAdId") int deniedEstateId, Model model) {

        model.addAttribute("deniedEstate", declinedAdRepository.findById(deniedEstateId));
        return "estates/declinedAd/showDeclinedAd";
    }

    //
    @PostMapping("/createDeclinedAd")
    public String createDeclinedAd(@ModelAttribute("declinedAd") DeclinedAdModel declinedAdModel, Model model) {

        model.addAttribute("declinedAds", declinedAdRepository.findAll());

        declinedAdRepository.save(declinedAdModel);
        return "redirect:/estates";
    }


    //@PostMapping("/delete/notification/{notificationId}")
    //public String delete(@PathVariable("notificationId") int id, Model model) {
    //    NotificationModel notificationModel = notificationRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
    //    notificationRepository.delete(notificationModel);
    //    model.addAttribute("notifications", notificationRepository.findAll());
    //    return "redirect:/books";
    //}

    @GetMapping("/newDeclinedAd")
    public String newDeclinedAd(@ModelAttribute("declinedAd") DeclinedAdModel declinedAdModel, Model model) {
        Iterable<EstateModel> estateModels = estateRepository.findAll();
        Iterable<UserModel> userModels = userRepository.findAll();
        model.addAttribute("estates", estateModels);
        model.addAttribute("users", userModels);
        model.addAttribute("declinedAds", declinedAdRepository.findAll());

        return "estates/declinedAd/newDeclinedAd";
    }
}
