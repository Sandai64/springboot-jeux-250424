package fr.esgi.jeux_erwan.Repositories;

import fr.esgi.jeux_erwan.business.Eleve;
import fr.esgi.jeux_erwan.business.Groupe;
import fr.esgi.jeux_erwan.business.Niveau;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class AddInitialData implements CommandLineRunner
{
    private final EleveRepository eleveRepository;
    private final NiveauRepository niveauRepository;
    private final GroupeRepository groupeRepository;
    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception
    {
        Niveau niveau = new Niveau("CE1");
        niveauRepository.save(niveau);

        Groupe groupe = new Groupe();
        groupe.setNom("H2O");
        groupeRepository.save(groupe);

        Eleve eleve = new Eleve();
        eleve.setNiveau(niveau);
        eleve.setPrenom("Capucine");
        eleve.setNom("DURAND");
        eleve.setDateHeureInscription(LocalDateTime.of(2024, 04, 25, 12, 00));
        eleve.setEmail("capucine@esgi.fr");
        eleve.setGroupes(new ArrayList<>());
        eleve.getGroupes().add(groupe);
        eleveRepository.save(eleve);

        // Requête 1 : les élèves nés en 2016
        eleveRepository.findAllBornIn2016().forEach(System.out.println);

    }
}