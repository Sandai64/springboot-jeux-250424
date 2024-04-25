package fr.esgi.jeux_erwan.controllers;

import fr.esgi.jeux_erwan.Repositories.EleveRepository;
import fr.esgi.jeux_erwan.business.Eleve;
import fr.esgi.jeux_erwan.helpers.ValidationHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class AuthController
{
    @RequestMapping(value = {"/auth"})
    public ModelAndView auth()
    {
        ModelAndView mav = new ModelAndView("auth");
        return mav;
    }

    @PostMapping(value = {"/auth/handler"})
    public String AuthHandler(@RequestParam String nom,
                              @RequestParam String prenom,
                              @RequestParam LocalDateTime dateDeNaissance,
                              @RequestParam String email,
                              @RequestParam String motDePasse)
    {
        // Vérification
        if ( motDePasse.length() < 4 || !ValidationHelper.hasUppercase(motDePasse) ) { throw new IllegalArgumentException("Format du mot de passe invalide."); }
        if ( !ValidationHelper.isValidEmailAddress(email) ) { throw new IllegalArgumentException("Format email invalide."); }
        if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ) { throw new IllegalArgumentException("Nom / Prénom invalide."); }
        if (!dateDeNaissance.isBefore(LocalDateTime.now())) { throw new IllegalArgumentException("Date de naissance invalide."); }

        Eleve eleve = new Eleve();
        eleve.setNom(nom);
        eleve.setPrenom("");
        // oups :(

        EleveRepository eleveRepository = new EleveRepository();
        eleveRepository.save(eleve);

        return "";
    }
}
