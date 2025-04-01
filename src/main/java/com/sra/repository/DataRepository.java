package com.sra.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
abstract class DataRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    DataRepository(EntityManager em) {
        this.entityManager =  em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    boolean isEmpty (Query query) {
            Long result = (Long) query.getSingleResult();
            return result == 0;
    }

    abstract List<?> getData();

    public <T> void addEntity(T entity) {
            entityManager.persist(entity);
    }

}
