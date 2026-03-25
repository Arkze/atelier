package com.example.springboot.infrastructure.rest;

import java.util.List;

import com.example.springboot.domain.ports.input.cat.LikeCatUseCase;
import com.example.springboot.domain.ports.input.cat.GetCatScoreUseCase;
import com.example.springboot.domain.ports.input.cat.GetRandomCatUseCase;
import com.example.springboot.domain.ports.input.cat.GetCatLeaderboardUseCase;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.models.enums.LikeType;
import com.example.springboot.infrastructure.rest.dtos.CatDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cats")
@Tag(name = "Cats", description = "Cat related operations")
@CrossOrigin(origins = {"http://localhost:4200", "http://ec2-51-44-216-186.eu-west-3.compute.amazonaws.com:4200"}, allowCredentials = "true")
public class CatController {

    private final GetCatScoreUseCase getCatScore;
    private final LikeCatUseCase likeCat;
    private final GetCatLeaderboardUseCase getCatLeaderboard;
    private final GetRandomCatUseCase getRandomCatUseCase;

    public CatController(
        GetCatScoreUseCase getCatScore,
        LikeCatUseCase likeCat,
        GetCatLeaderboardUseCase getCatLeaderboard,
        GetRandomCatUseCase getRandomCatUseCase
    ) {
        this.getCatScore = getCatScore;
        this.likeCat = likeCat;
        this.getCatLeaderboard = getCatLeaderboard;
        this.getRandomCatUseCase = getRandomCatUseCase;
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
        return ResponseEntity.ok(this.getCatScore.getScore(catId)); // could be nothing - just "OK"
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

    @GetMapping("/leaderboard")
    public List<CatDTO> getLeaderboard() {

        return this.getCatLeaderboard.getLeaderboard()
                .stream()
                .map(cat -> new CatDTO(cat.getId(), cat.getImage(), cat.getScore()))
                .toList();
    }

    
    @GetMapping("/random")
    public List<CatDTO> getRandomCats() {
        return this.getRandomCatUseCase.getRandomCat()
                .stream()
                .map(cat -> new CatDTO(cat.getId(), cat.getImage(), cat.getScore()))
                .toList();  
    }
}
