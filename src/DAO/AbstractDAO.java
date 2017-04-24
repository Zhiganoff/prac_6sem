package DAO;

import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public abstract class AbstractDAO<T> {
    private Class<T> type;
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

    public void addSample(T entity) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public List<T> getAll() {
        List<T> res;
        EntityManager em = HibernateUtil.getEm();
        res = em.createQuery("select c from " + type.getSimpleName() + " c", type).getResultList();
        em.close();
        return res;
    }

    public void deleteById(Long id) {
        T delCandidate;
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        delCandidate = em.find(type, id);
        em.remove(delCandidate);
        em.getTransaction().commit();
        em.close();
    }

    public void updateSample(T entity) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public T getById(Long id) {
        T entity;
        EntityManager em = HibernateUtil.getEm();
        entity = em.find(type, id);
        em.close();
        return entity;
    }
}
