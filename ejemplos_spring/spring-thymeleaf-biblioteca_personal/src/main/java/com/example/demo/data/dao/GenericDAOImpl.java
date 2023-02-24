package com.example.demo.data.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

    @PersistenceContext
    protected EntityManager em;
    protected final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Optional<T> findById(K id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }

    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    public T save(T entity) {
        return em.merge(entity);
    }

    @Override
    public void deleteById(Long id) {
        em.remove(em.find(entityClass, id));
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void refresh(T entity) {
        em.refresh(entity);
    }

    @Override
    public Long count() {
        /*return em.createQuery("SELECT COUNT(entity) FROM " + entityClass.getSimpleName() + "  entity",
                        Long.class)
                .getSingleResult();*/
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<T> root = cq.from(entityClass);

        cq.select(cb.count(root));
        return em.createQuery(cq)
                .getSingleResult();
    }

}
