package fr.esgi.jeux_erwan.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Data
public class Groupe
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Size(max = 200)
    private String description;

    @ManyToMany
    private ArrayList<Eleve> eleves;
}
