package com.luthando.survey.controller;

import com.luthando.survey.dto.RespondentDTO;
import com.luthando.survey.entity.Respondent;
import com.luthando.survey.entity.Response;
import com.luthando.survey.service.RespondentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
public class RespondentController {

    private final RespondentService service;
    @PostMapping("/save")
    public ResponseEntity<Response> saveResponse(@RequestBody RespondentDTO dto) {
        return ResponseEntity.ok(
            Response.builder()
                    .data(Map.of("response", service.saveResponse(dto)))
                    .message("Response Saved")
                    .status(HttpStatus.CREATED)
                    .statusCode(HttpStatus.CREATED.value())
                    .build()
        );
    }
    @GetMapping("/total-surveyers")
    public Integer getNumberOfSurveys() {
        return service.getNumberOfSurveys();
    }
    @GetMapping("/average-age")
    public Integer getAverageAge() {
        return service.getAverageAge();
    }
    @GetMapping("/oldest")
    public Integer oldestRespondent() {
        return service.oldestRespondent();
    }
    @GetMapping("/youngest")
    public Integer youngestRespondent() {
        return service.youngestRespondent();
    }
    @GetMapping("percentage-pizza-likers")
    public Integer percentageOfPizzaLikers() {
        return service.percentageOfPizzaLikers();
    }
    @GetMapping("percentage-pasta-likers")
    public Integer percentageOfPastaLikers() {
        return service.percentageOfPastaLikers();
    }
    @GetMapping("percentage-padandwors-likers")
    public Integer percentageOfPadAndWorsLikers() {
        return service.percentageOfPadAndWorsLikers();
    }
    @GetMapping("eat-out-average")
    public Integer eatOutAverage() {
        return service.eatOutAverage();
    }
    @GetMapping("watch-movie-average")
    public Integer watchMovie() {
        return service.watchMovie();
    }
    @GetMapping("watch-tv-average")
    public Integer watchTv() {
        return service.watchTv();
    }
    @GetMapping("listen-radio-average")
    public Integer listenToRadio() {
        return service.listenToRadio();
    }
}
