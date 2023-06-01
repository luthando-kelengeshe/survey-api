package com.luthando.survey.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RespondentDTO {
    private String lastName;
    private String firstName;
    private String contactNumber;
    private Integer age;
    private Date surveyDate;
    private String pizza;
    private String pasta;
    private String papAndWors;
    private String chickenStirFry;
    private String beefStirFry;
    private String other;
    private Integer eatOut;
    private Integer watchMovie;
    private Integer watchTv;
    private Integer listenToRadio;
}
