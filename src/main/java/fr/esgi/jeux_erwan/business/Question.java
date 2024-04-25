package fr.esgi.jeux_erwan.business;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Data
public class Question
{
    @Id
    private Long id;

    @OneToOne
    private Categorie categorie;

    private String libelle;
    private String bonneReponse;

    @OneToMany
    private ArrayList<Quiz> quizzes;
}
