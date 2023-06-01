package com.luthando.survey.service;

import com.luthando.survey.dto.RespondentDTO;
import com.luthando.survey.entity.Food;
import com.luthando.survey.entity.Preference;
import com.luthando.survey.entity.Respondent;
import com.luthando.survey.entity.Response;
import com.luthando.survey.repo.FoodRepo;
import com.luthando.survey.repo.PreferenceRepo;
import com.luthando.survey.repo.RespondentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RespondentService {

    private final RespondentRepo respondentRepo;

    private final FoodRepo foodRepo;

    private final PreferenceRepo preferenceRepo;

    public RespondentDTO saveResponse(RespondentDTO dto) {

        //mapping dto to entities
        Respondent respondent = new Respondent();
        respondent.setLastName(dto.getLastName());
        respondent.setFirstName(dto.getFirstName());
        respondent.setContactNumber(dto.getContactNumber());
        respondent.setAge(dto.getAge());
        respondent.setSurveyDate(dto.getSurveyDate());

        Food food = new Food();
        food.setPizza(dto.getPizza());
        food.setPasta(dto.getPasta());
        food.setPapAndWors(dto.getPapAndWors());
        food.setChickenStirFry(dto.getChickenStirFry());
        food.setBeefStirFry(dto.getBeefStirFry());
        food.setOther(dto.getOther());

        Preference preference = new Preference();
        preference.setEatOut(dto.getEatOut());
        preference.setWatchMovie(dto.getWatchMovie());
        preference.setWatchTv(dto.getWatchTv());
        preference.setListenToRadio(dto.getListenToRadio());

        //saving entities
        respondentRepo.save(respondent);
        food.setRespondent(respondent);
        preference.setRespondent(respondent);

        foodRepo.save(food);
        preferenceRepo.save(preference);

        return dto;
    }

    public Integer getNumberOfSurveys() {
        return respondentRepo.getNumberOfSurveys();
    }
    public Integer getAverageAge() {
        return respondentRepo.getAverageAge();
    }
    public Integer oldestRespondent() {
        return respondentRepo.oldestRespondent();
    }
    public Integer youngestRespondent() {
        return respondentRepo.youngestRespondent();
    }
    public Integer percentageOfPizzaLikers() {
        return foodRepo.percentageOfPizzaLikers();
    }
    public Integer percentageOfPastaLikers() {
        return foodRepo.percentageOfPastaLikers();
    }
    public Integer percentageOfPadAndWorsLikers() {
        return  foodRepo.percentageOfPadAndWorsLikers();
    }
    public Integer eatOutAverage() {
        return preferenceRepo.eatOutAverage();
    }
    public Integer watchMovie() {
        return preferenceRepo.watchMovie();
    }
    public Integer watchTv() {
        return preferenceRepo.watchTv();
    }
    public Integer listenToRadio() {
        return preferenceRepo.listenToRadio();
    }
}
