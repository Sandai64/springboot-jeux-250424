package fr.esgi.jeux_erwan.Repositories;

import fr.esgi.jeux_erwan.business.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NiveauRepository
{

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Niveau niveau)
    {
        entityManager.persist(niveau);
    }

    public Niveau findById(Long id)
    {
        return entityManager.find(Niveau.class, id);
    }

    public void update(Niveau niveau)
    {
        entityManager.merge(niveau);
    }

    public void delete(Niveau niveau)
    {
        entityManager.remove(niveau);
    }
}
