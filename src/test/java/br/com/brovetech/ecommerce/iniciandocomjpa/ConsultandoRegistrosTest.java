package br.com.brovetech.ecommerce.iniciandocomjpa;

import br.com.brovetech.ecommerce.EntityManagerTest;
import br.com.brovetech.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {


    @Test
    public void buscarIdentificador(){
        var produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
    }
}
