package fr.esgi.jeux_erwan.business;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class Multiplication extends Jeu
{
    private int nombre1 = (int)(Math.random()*10)+1;
    private int nombre2 = (int)(Math.random()*10)+1;
    private int reponse = nombre1 * nombre2;
}
