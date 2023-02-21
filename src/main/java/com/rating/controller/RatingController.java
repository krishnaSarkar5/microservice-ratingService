package com.rating.controller;

import com.rating.entities.Rating;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create-rating")
    public Rating create(@RequestBody Rating rating){
        return ratingService.create(rating);
    }

    @GetMapping
    public List<Rating> getRatings(){
        return ratingService.getRatings();
    }


    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/get-by-userId")
    public List<Rating> getRatingsByUserId(@RequestParam("userId") String userId){
        return ratingService.getRatingByUserId(userId);
    }

    @GetMapping("/get-by-hotelId")
    public List<Rating> getRatingsByHotelId(@RequestParam("hotelId") String hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }
}
