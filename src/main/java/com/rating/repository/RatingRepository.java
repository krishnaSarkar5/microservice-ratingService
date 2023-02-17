package com.rating.repository;

import com.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {

    public List<Rating> findAllByUserId(String userId);

    public List<Rating> findAllByHotelId(String hotelId);
}
