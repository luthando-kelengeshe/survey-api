package com.luthando.survey.repo;

import com.luthando.survey.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepo extends JpaRepository<Food, Long> {
    @Query("SELECT (\n" +
            "\t(SELECT COUNT(*) \n" +
            "\t FROM Food \n" +
            "\t where pizza = 'Yes') /\n" +
            "  \t(SELECT COUNT(*) \n" +
            "\t FROM Food) * 100) as pizza_likers")
    Integer percentageOfPizzaLikers();
    @Query("SELECT (\n" +
            "\t(SELECT COUNT(*) \n" +
            "\t FROM Food \n" +
            "\t where pasta = 'Yes') /\n" +
            "  \t(SELECT COUNT(*) \n" +
            "\t FROM Food) * 100) as pasta_likers")
    Integer percentageOfPastaLikers();
    @Query("SELECT (\n" +
            "\t(SELECT COUNT(*) \n" +
            "\t FROM Food \n" +
            "\t where papAndWors = 'Yes') /\n" +
            "  \t(SELECT COUNT(*) \n" +
            "\t FROM Food) * 100) as pap_and_wors_likers")
    Integer percentageOfPadAndWorsLikers();
}
