package com.luthando.survey.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pizza;
    private String pasta;
    private String papAndWors;
    private String chickenStirFry;
    private String beefStirFry;
    private String other;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "respondent_id", referencedColumnName = "id")
    private Respondent respondent;
}
