package ru.shakirova.puzzle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.shakirova.puzzle.entity.Question;
import ru.shakirova.puzzle.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User getById(int id){
        return  entityManager.find(User.class, id);
    }

    public User add(User user){
        entityManager.getTransaction().begin();
        User userFromDB = entityManager.merge(user);
        entityManager.getTransaction().commit();
        return userFromDB;
    }

    public void update(User user){
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void delete(User user){
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public List<User> getAll(){
        List<User> users = entityManager.createQuery(DBQuery.SELECT_ALL_USERS).getResultList();
        return users;
    }

    public List<User> getAllByQuestion(Question question){
        List<User> users = entityManager.createQuery(DBQuery.SELECT_ALL_USERS_BY_QUESTION).setParameter(1, question).getResultList();
        return users;
    }

}
