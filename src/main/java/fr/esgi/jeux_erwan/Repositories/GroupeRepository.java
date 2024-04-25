package fr.esgi.jeux_erwan.Repositories;

import fr.esgi.jeux_erwan.business.Groupe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GroupeRepository
{

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Groupe groupe)
    {
        entityManager.persist(groupe);
    }

    public Groupe findById(Long id)
    {
        return entityManager.find(Groupe.class, id);
    }

    public void update(Groupe groupe)
    {
        entityManager.merge(groupe);
    }

    public void delete(Groupe groupe)
    {
        entityManager.remove(groupe);
    }
}
