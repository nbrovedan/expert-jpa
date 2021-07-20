package br.com.brovetech.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "item_pedido")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Column(name = "produto_id")
    private Integer produtoId;
    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
    private Integer quantidade;

}
