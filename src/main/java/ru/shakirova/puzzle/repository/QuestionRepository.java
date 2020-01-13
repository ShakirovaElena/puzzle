package ru.shakirova.puzzle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.shakirova.puzzle.entity.DifficultyLevel;
import ru.shakirova.puzzle.entity.Question;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class QuestionRepository {

    private final EntityManager entityManager;

    @Autowired
    public QuestionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Question findById(int id){
         return entityManager.find(Question.class, id);
    }

    public Question add(Question question){
        entityManager.getTransaction().begin();
        Question questionFromDB = entityManager.merge(question);
        entityManager.getTransaction().commit();
        return questionFromDB;
    }

    public void delete(Question question){
        entityManager.getTransaction().begin();
        entityManager.remove(question);
        entityManager.getTransaction().commit();
    }

    public void update(Question question){
        entityManager.getTransaction().begin();
        entityManager.merge(question);
        entityManager.getTransaction().commit();
    }

    public List<Question> getAll(){
        List<Question> questions = entityManager.createQuery(DBQuery.SELECT_QUESTION_ALL).getResultList();
        return questions;
    }

    public List<Question> getByDifficultyLevel(DifficultyLevel difficultyLevel){
        List<Question> questions = entityManager.createQuery(DBQuery.SELECT_QUESTION_BY_DIF_LEV).setParameter(1, difficultyLevel).getResultList();
        return questions;
    }

}
