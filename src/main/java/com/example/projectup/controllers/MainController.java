package com.example.projectup.controllers;

import com.example.projectup.models.*;
import com.example.projectup.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/estates")
@Controller
public class MainController {
    private final EstateRepository estateRepository;
    private final DeclinedAdRepository declinedAdRepository;
    private final NotificationRepository notificationRepository;
    private final TagAndEstateRepository tagAndEstateRepository;
    private final TagRepository tagRepository;
    private final UserHistoryWatchedRepository userHistoryWatchedRepository;
    private final UserRepository userRepository;
    private final UserReviewRepository userReviewRepository;
    private final WatchLaterEstatesRepository watchLaterEstatesRepository;

    @Autowired

    public MainController( EstateRepository estateRepository,
                           DeclinedAdRepository declinedAdRepository,
                           NotificationRepository notificationRepository,
                           TagAndEstateRepository tagAndEstateRepository,
                           TagRepository tagRepository,
                           UserHistoryWatchedRepository userHistoryWatchedRepository,
                           UserRepository userRepository,
                           UserReviewRepository userReviewRepository,
                           WatchLaterEstatesRepository watchLaterEstatesRepository) {
        this.estateRepository = estateRepository;
        this.declinedAdRepository = declinedAdRepository;
        this.notificationRepository = notificationRepository;
        this.tagAndEstateRepository = tagAndEstateRepository;
        this.tagRepository = tagRepository;
        this.userHistoryWatchedRepository = userHistoryWatchedRepository;
        this.userRepository = userRepository;
        this.userReviewRepository = userReviewRepository;
        this.watchLaterEstatesRepository = watchLaterEstatesRepository;
    }
    @GetMapping()
    public String index(Model model) {

        //model.addAttribute("books", bookDao.getAll());
        //model.addAttribute("authors", authorDao.getAll());
        //model.addAttribute("libraries", libraryDao.getAll());
        //model.addAttribute("publishers", publisherDao.getAll());
        //model.addAttribute("reviews", reviewDao.getAll());
        List<EstateModel> estate = estateRepository.findAll();
        List<NotificationModel> notification = notificationRepository.findAll();
        List<DeclinedAdModel> declinedAd = declinedAdRepository.findAll();
        List<TagAndEstateModel> tagAndEstate = tagAndEstateRepository.findAll();
        List<UserHistoryWatchedModel> userHistoryWatched = userHistoryWatchedRepository.findAll();
        List<UserModel> users = userRepository.findAll();
        List<UserReviewModel> userReview = userReviewRepository.findAll();
        List<TagModel> tagModels = tagRepository.findAll();
        List<WatchLaterEstatesModel> watchLaterEstates = watchLaterEstatesRepository.findAll();

        model.addAttribute("estates", estate);
        model.addAttribute("notifications", notification);
        model.addAttribute("declinedAds", declinedAd);
        model.addAttribute("tagsAndEstates", tagAndEstate);
        model.addAttribute("usersHistoryWatched", userHistoryWatched);
        model.addAttribute("users", users);
        model.addAttribute("usersReview", userReview);
        model.addAttribute("watchLaterEstates", watchLaterEstates);
        model.addAttribute("tags", tagModels);
        return "estates/index";
    }
    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("estate", estateRepository.findById(id));
        return "estates/estate/show";
    }
    @GetMapping("/user/new")
    public String newEstate(@ModelAttribute("estate") EstateModel estateModel, Model model ) {
        Iterable<EstateModel> estates = estateRepository.findAll();
        model.addAttribute("estates", estates);
        return "estates/estate/new";
    }
    @PostMapping("/user/createEstate")

    public String createEstate (@ModelAttribute("estate") EstateModel estateModel, Model model){
        estateRepository.save(estateModel);
        model.addAttribute("estates", estateRepository.findAll());
        return "redirect:/estates";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {

        EstateModel estateModel = estateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("estate", estateModel);

        return "estates/estate/edit";
    }


    @PostMapping("user/{id}/update")
    public String update(@Valid EstateModel estate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/estates";
        }
        estateRepository.save(estate);
        model.addAttribute("estates", estateRepository.findAll());
        return "redirect:/estates";
    }
    @PostMapping("/user/delete/{id}")
    public String delete ( @PathVariable("id") Long id, Model model){
        EstateModel estateModel = estateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        estateRepository.delete(estateModel);
        model.addAttribute("estates", estateRepository.findAll());
        return "redirect:/estates";
    }
}
