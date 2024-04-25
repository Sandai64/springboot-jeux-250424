package fr.esgi.jeux_erwan.Repositories;

import fr.esgi.jeux_erwan.business.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class QuestionRepository
{

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Question question)
    {
        entityManager.persist(question);
    }

    public Question findById(Long id)
    {
        return entityManager.find(Question.class, id);
    }

    public void update(Question question)
    {
        entityManager.merge(question);
    }

    public void delete(Question question)
    {
        entityManager.remove(question);
    }
}
