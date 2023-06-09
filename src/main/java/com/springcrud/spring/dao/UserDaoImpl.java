package com.springcrud.spring.dao;

import com.springcrud.spring.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> getUser(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> userToFind = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        return userToFind;
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User userToDelete = entityManager.find(User.class, id);
        System.out.println(userToDelete.getName());
        entityManager.remove(userToDelete);
    }
}
