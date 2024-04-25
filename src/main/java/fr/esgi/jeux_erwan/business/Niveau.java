package fr.esgi.jeux_erwan.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
public class Niveau
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long   id;

    private String nom;
    private ArrayList<Eleve> eleves;

    public Niveau(String nom)
    {
        this.nom = nom;
        this.eleves = new ArrayList<>();
    }
}
