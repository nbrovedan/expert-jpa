package br.com.brovetech.ecommerce.util;

import br.com.brovetech.ecommerce.model.Produto;

import javax.persistence.Persistence;

public class IniciarUnidadePersistencia {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        var entityManager = entityManagerFactory.createEntityManager();

        var produto = entityManager.find(Produto.class, 1);

        System.out.println(produto.getNome());

        entityManager.close();
        entityManagerFactory.close();
    }
}
