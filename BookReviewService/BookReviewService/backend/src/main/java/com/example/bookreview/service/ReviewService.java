package com.example.bookreview.service;

import com.example.bookreview.model.Review;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getAllReviews() {
        return reviews;
    }
}
