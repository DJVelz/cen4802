package com.example.bookreview.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bookreview.model.Review;
import com.example.bookreview.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService service;
    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Review review, HttpServletRequest req) {
        service.addReview(review);
        log.info("Review added from IP: {}, book: {}", req.getRemoteAddr(), review.getBookTitle());
        return ResponseEntity.ok("Review added");
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }
}
