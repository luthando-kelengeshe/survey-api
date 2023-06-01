package com.luthando.survey.repo;

import com.luthando.survey.entity.Respondent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RespondentRepo extends JpaRepository<Respondent, Long> {

    @Query("SELECT COUNT(*) AS number_of_surveys FROM Respondent")
    Integer getNumberOfSurveys();
    @Query("SELECT AVG(age) AS average_age FROM Respondent WHERE age IS NOT NULL")
    Integer getAverageAge();
    @Query("SELECT MAX(age) AS max_age \n" +
            "FROM Respondent")
    Integer oldestRespondent();

    @Query("SELECT MIN(age) AS min_age \n" +
            "FROM Respondent")
    Integer youngestRespondent();
}
