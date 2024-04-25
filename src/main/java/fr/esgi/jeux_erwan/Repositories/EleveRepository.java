package fr.esgi.jeux_erwan.Repositories;

import fr.esgi.jeux_erwan.business.Eleve;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public class EleveRepository
{

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Eleve eleve)
    {
        entityManager.persist(eleve);
    }

    public Eleve findById(Long id)
    {
        return entityManager.find(Eleve.class, id);
    }

    public void update(Eleve eleve)
    {
        entityManager.merge(eleve);
    }

    public void delete(Eleve eleve)
    {
        entityManager.remove(eleve);
    }

    public ArrayList<Eleve> findAllBornIn2016()
    {
        ArrayList<Eleve> all = (ArrayList<Eleve>) entityManager.createQuery("SELECT a FROM A a", Eleve.class).getResultList();
        ArrayList<Eleve> filtered = new ArrayList<>();

        for (Eleve e : all)
        {
            if ( e.getDateDeNaissance().getYear() == 2016 )
            {
                filtered.add(e);
            }
        }

        return filtered;
    }
}
