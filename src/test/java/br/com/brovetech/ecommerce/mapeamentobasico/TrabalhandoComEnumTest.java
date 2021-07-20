package br.com.brovetech.ecommerce.mapeamentobasico;

import br.com.brovetech.ecommerce.EntityManagerTest;
import br.com.brovetech.ecommerce.enumeration.SexoClienteEnum;
import br.com.brovetech.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

import static br.com.brovetech.ecommerce.enumeration.SexoClienteEnum.NAO_INFORMADO;

public class TrabalhandoComEnumTest extends EntityManagerTest<Cliente> {

    @Test
    public void SalvandoEnum(){
        var cliente = new Cliente();
        cliente.setId(4);
        cliente.setNome("Darth Vader");
        cliente.setSexoCliente(NAO_INFORMADO);
        this.persist(cliente);
        entityManager.clear();

        var clienteTeste = this.find(4);
        Assert.assertNotNull(clienteTeste);
        Assert.assertEquals(NAO_INFORMADO, clienteTeste.getSexoCliente());
    }
}
