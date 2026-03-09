package com.example.springboot.infrastructure.rest;

import com.example.springboot.domain.ports.input.cat.LikeCatUseCase;
import com.example.springboot.domain.ports.input.cat.GetCatScoreUseCase;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.models.enums.LikeType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cats")
@Tag(name = "Cats", description = "Cat related operations")
public class CatController {

    private final GetCatScoreUseCase getCatScore;
    private final LikeCatUseCase likeCat;

    public CatController(GetCatScoreUseCase getCatScore, LikeCatUseCase likeCat) {
        this.getCatScore = getCatScore;
        this.likeCat = likeCat;
    }

    @Operation(summary = "Credit a cat's score from a like", responses = {
            @ApiResponse(responseCode = "200", description = "Score updated"),
            @ApiResponse(responseCode = "404", description = "Cat not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping("/{catId}/like")
    public ResponseEntity<Integer> creditLikeScore(
            @PathVariable String catId
    ) {
        this.likeCat.like(catId, LikeType.LIKE);
        return ResponseEntity.ok(this.getCatScore.getScore(catId));
    }

        @Operation(summary = "Credit a cat's score from a superLike", responses = {
            @ApiResponse(responseCode = "200", description = "Score updated"),
            @ApiResponse(responseCode = "404", description = "Cat not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping("/{catId}/super-like")
    public ResponseEntity<Integer> creditSuperLikeScore(
            @PathVariable String catId
    ) {
        this.likeCat.like(catId, LikeType.SUPER_LIKE);
        return ResponseEntity.ok(this.getCatScore.getScore(catId));
    }

    @Operation(summary = "Get cat score", responses = {
            @ApiResponse(responseCode = "200", description = "Score returned"),
            @ApiResponse(responseCode = "404", description = "Cat not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping("/{catId}/score")
    public ResponseEntity<Integer> getScore(@PathVariable String catId) {
        return ResponseEntity.ok(this.getCatScore.getScore(catId));
    }
}
