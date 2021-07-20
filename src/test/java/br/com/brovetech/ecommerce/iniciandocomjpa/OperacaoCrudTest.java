package br.com.brovetech.ecommerce.iniciandocomjpa;

import br.com.brovetech.ecommerce.EntityManagerTest;
import br.com.brovetech.ecommerce.model.Cliente;
import org.junit.Test;

public class OperacaoCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro(){
        var cliente = new Cliente();
        cliente.setId(2);
        cliente.setNome("Fulano");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    @Test
    public void buscarRegistro(){
        var cliente = entityManager.find(Cliente.class, 1);
        System.out.println(cliente.getNome());
    }

    @Test
    public void atualizarRegistro(){
        var cliente = entityManager.find(Cliente.class, 1);
        cliente.setNome("Beltrano da silva");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    @Test
    public void deletarRegistro(){
        var cliente = entityManager.find(Cliente.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }

}
