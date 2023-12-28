package com.example.projectup.controllers;

import com.example.projectup.models.EstateModel;
import com.example.projectup.models.NotificationModel;
import com.example.projectup.models.UserModel;
import com.example.projectup.models.WatchLaterEstatesModel;
import com.example.projectup.repositories.EstateRepository;
import com.example.projectup.repositories.NotificationRepository;
import com.example.projectup.repositories.UserRepository;
import com.example.projectup.repositories.WatchLaterEstatesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estates")
public class WatchLaterEstatesController {
    private final EstateRepository estateRepository;
    private final UserRepository userRepository; ;
    private final WatchLaterEstatesRepository watchLaterEstatesRepository;

    @Autowired
    public WatchLaterEstatesController(EstateRepository estateRepository,
                                       UserRepository userRepository, WatchLaterEstatesRepository watchLaterEstatesRepository) {
        this.estateRepository = estateRepository;
        this.userRepository = userRepository;
        this.watchLaterEstatesRepository =  watchLaterEstatesRepository;
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
    //@PatchMapping("/libraries/{libraryId}")
    //public String updateLibrary(@ModelAttribute("library") LibraryModel library, @PathVariable("libraryId") int libraryId) {
    //    libraryDao.update(libraryId, library);
    //    return "redirect:/books";
    //}


   // @GetMapping("/notifications/{notificationId}/notificationEdit")
   // public String notificationEdit(Model model, @PathVariable("notificationId") int libraryId) {
   //     NotificationModel notificationModel = notificationRepository.findById((long) libraryId).orElseThrow(()
   //             -> new IllegalArgumentException("Invalid customer Id:" + libraryId));
   //     model.addAttribute("notification", notificationModel);
   //     return "estates/notification/editNotification";
   // }
//
   //
   @GetMapping("/watchLaterEstates/{watchLaterEstatesId}")
   public String showNotification(@PathVariable("watchLaterEstatesId") Long id, Model model) {

       model.addAttribute("watchLaterEstate", watchLaterEstatesRepository.findById(id));
       return "estates/watchLaterEstate/showWatchLaterEstate";
   }

    //
    @PostMapping("/createWatchLaterEstates")
    public String createNotification(@ModelAttribute("watchLaterEstate") WatchLaterEstatesModel watchLaterEstatesModel, Model model) {
        Iterable<UserModel> userModels = userRepository.findAll();
        Iterable<EstateModel> estateModels = estateRepository.findAll();

        model.addAttribute("users", userModels);
        model.addAttribute("estates", estateModels);
        watchLaterEstatesRepository.save(watchLaterEstatesModel);
        return "redirect:/estates";
    }


     @PostMapping("/delete/watchLaterEstate/{watchLaterEstateId}")
     public String delete(@PathVariable("watchLaterEstateId") int id, Model model) {
         WatchLaterEstatesModel watchLaterEstatesModel = watchLaterEstatesRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
         watchLaterEstatesRepository.delete(watchLaterEstatesModel);
         model.addAttribute("watchLaterEstates", watchLaterEstatesRepository.findAll());
         return "redirect:/estates";
     }

    @GetMapping("/newWatchLaterEstate")
    public String newWatchLaterEstate(@ModelAttribute("watchLaterEstate") WatchLaterEstatesModel watchLaterEstatesModel, Model model) {
        Iterable<UserModel> userModels = userRepository.findAll();
        Iterable<EstateModel> estateModels = estateRepository.findAll();

        model.addAttribute("users", userModels);
        model.addAttribute("estates",  estateModels);

        watchLaterEstatesRepository.save(watchLaterEstatesModel);
        return "estates/watchLaterEstate/newWatchLaterEstate";
    }
}
