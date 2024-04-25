package fr.esgi.jeux_erwan.business;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Data
public class Eleve
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private LocalDateTime dateHeureInscription;
    private String email;
    private String motDePasse;

    @OneToMany
    private Niveau niveau;

    @ManyToMany
    private ArrayList<Groupe> groupes;

    @OneToMany
    private ArrayList<Jeu> jeux;
}
