package ru.shakirova.puzzle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.shakirova.puzzle.entity.Answer;
import ru.shakirova.puzzle.entity.Question;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AnswerRepository {

    private final EntityManager entityManager;

    @Autowired
    public AnswerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Answer findById(int id){
        return entityManager.find(Answer.class, id);
    }

    public Answer add(Answer answer){
        entityManager.getTransaction().begin();
        Answer answerFromDB = entityManager.merge(answer);
        entityManager.getTransaction().commit();
        return answerFromDB;
    }

    public void delete(Answer answer){
        entityManager.getTransaction().begin();
        entityManager.remove(answer);
        entityManager.getTransaction().commit();
    }

    public void update(Answer answer){
        entityManager.getTransaction().begin();
        entityManager.merge(answer);
        entityManager.getTransaction().commit();
    }

    public List<Answer> getAllByQuestion(Question question){
        List<Answer> answers = entityManager.createQuery(DBQuery.SELECT_ANSWERS_BY_QUESTION).setParameter(1, question).getResultList();
        return answers;
    }
}
