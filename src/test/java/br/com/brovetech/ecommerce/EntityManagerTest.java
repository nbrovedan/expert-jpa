package br.com.brovetech.ecommerce;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

public class EntityManagerTest<T> {

    private static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<T> classType;

    @BeforeClass
    public static void initClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");

    }

    @Before
    public void init(){
        entityManager = entityManagerFactory.createEntityManager();
        this.classType = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @After
    public void end(){
        entityManager.close();
    }

    @AfterClass
    public static void endClass(){
        entityManagerFactory.close();
    }

    public void persist(T t){
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public T merge(T t){
        entityManager.getTransaction().begin();
        t = entityManager.merge(t);
        entityManager.getTransaction().commit();
        return t;
    }

    public T find(Integer id){
        return entityManager.find(classType, id);
    }
}
