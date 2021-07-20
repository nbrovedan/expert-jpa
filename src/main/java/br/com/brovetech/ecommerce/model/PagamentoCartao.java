package br.com.brovetech.ecommerce.model;

import br.com.brovetech.ecommerce.enumeration.StatusPagamentoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Table(name = "pagamento_cartao")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PagamentoCartao {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status;
    private String numero;

}
