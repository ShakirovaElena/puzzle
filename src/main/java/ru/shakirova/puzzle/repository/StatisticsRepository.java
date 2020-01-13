package ru.shakirova.puzzle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.shakirova.puzzle.entity.Question;
import ru.shakirova.puzzle.entity.Statistics;
import ru.shakirova.puzzle.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StatisticsRepository {

    private final EntityManager entityManager;

    @Autowired
    public StatisticsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Statistics getById(int id){
        return entityManager.find(Statistics.class, id);
    }

    public Statistics add(Statistics statistics){
        entityManager.getTransaction().begin();
        Statistics statisticsFromDB = entityManager.merge(statistics);
        entityManager.getTransaction().commit();
        return statisticsFromDB;
    }

    public void update(Statistics statistics){
        entityManager.getTransaction().begin();
        entityManager.merge(statistics);
        entityManager.getTransaction().commit();
    }

    public List<Statistics> getAllByQuestion(Question question){
        List<Statistics> statistics = entityManager.createQuery(DBQuery.SELECT_STATISTICS_BY_QUESTION).setParameter(1, question).getResultList();
        return statistics;
    }

    public List<Statistics> getAllByUser(User user){
        List<Statistics> statistics = entityManager.createQuery(DBQuery.SELECT_STATISTICS_BY_USER).setParameter(1, user).getResultList();
        return statistics;
    }

}
