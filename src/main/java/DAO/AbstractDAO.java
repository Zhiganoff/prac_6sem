package DAO;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDAO<T> {
    private Class<T> type;
    @PersistenceContext private EntityManager em;
    public AbstractDAO() {
        Type type = getClass().getGenericSuperclass();

        // Get generic type of class at runtime
        while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != AbstractDAO.class) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        this.type = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    @Transactional
    public void addSample(T entity) {
        em.persist(entity);
    }

    public List<T> getAll() {
        System.out.println("begin getAll " + em);
//        TypedQuery<T> query = em.createQuery("select c from " + type.getSimpleName() + " c", type);
        System.out.println("end getAll");
//        return query.getResultList();
        return Collections.emptyList();
    }

//    public void deleteById(Long id) {
//        T delCandidate;
//        EntityManager em = HibernateUtil.getEm();
//        em.getTransaction().begin();
//        delCandidate = em.find(type, id);
//        em.remove(delCandidate);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    public void updateSample(T entity) {
//        EntityManager em = HibernateUtil.getEm();
//        em.getTransaction().begin();
//        em.merge(entity);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    public T getById(Long id) {
//        T entity;
//        EntityManager em = HibernateUtil.getEm();
//        entity = em.find(type, id);
//        em.close();
//        return entity;
//    }
}
