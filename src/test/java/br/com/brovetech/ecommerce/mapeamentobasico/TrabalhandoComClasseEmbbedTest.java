package br.com.brovetech.ecommerce.mapeamentobasico;

import br.com.brovetech.ecommerce.EntityManagerTest;
import br.com.brovetech.ecommerce.enumeration.StatusPedidoEnum;
import br.com.brovetech.ecommerce.model.EnderecoEntregaPedido;
import br.com.brovetech.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static br.com.brovetech.ecommerce.enumeration.StatusPedidoEnum.AGUARDANDO;

public class TrabalhandoComClasseEmbbedTest extends EntityManagerTest<Pedido> {

    @Test
    public void salvarClassEmbbed(){
        var enderecoEntrega = EnderecoEntregaPedido.builder()
                .cep("88132-229")
                .bairro("Pagani")
                .cidade("Palhoça")
                .estado("SC")
                .logradouro("Rua Capri")
                .numero("480")
                .build();

        var pedido = Pedido.builder()
                .id(4)
                .dataPedido(LocalDateTime.now())
                .dataConclusao(LocalDateTime.now().plusDays(3))
                .notaFiscalId(123533)
                .enderecoEntrega(enderecoEntrega)
                .status(AGUARDANDO)
                .total(BigDecimal.valueOf(19982.46))
                .build();

        this.persist(pedido);
        entityManager.clear();

        var pedidoTest = this.find(4);

        Assert.assertNotNull(pedidoTest);
        Assert.assertNotNull(pedidoTest.getEnderecoEntrega());
        Assert.assertNotNull(pedidoTest.getEnderecoEntrega().getCep());
        Assert.assertEquals(enderecoEntrega.getCep(), pedidoTest.getEnderecoEntrega().getCep());
    }
}
