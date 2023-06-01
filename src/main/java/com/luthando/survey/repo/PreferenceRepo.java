package com.luthando.survey.repo;

import com.luthando.survey.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PreferenceRepo extends JpaRepository<Preference, Long> {
    @Query("SELECT AVG(eatOut) AS average_eat_out \n" +
            "FROM Preference\n" +
            "WHERE eatOut IS NOT NULL")
    Integer eatOutAverage();
    @Query("SELECT AVG(watchMovie) AS average_watch_movie \n" +
            "FROM Preference\n" +
            "WHERE watchMovie IS NOT NULL")
    Integer watchMovie();
    @Query("SELECT AVG(watchTv) AS average_watch_tv \n" +
            "FROM Preference\n" +
            "WHERE watchTv IS NOT NULL")
    Integer watchTv();
    @Query("SELECT AVG(listenToRadio) AS average_listen_to_radio\n" +
            "FROM Preference\n" +
            "WHERE listenToRadio IS NOT NULL")
    Integer listenToRadio();
}
