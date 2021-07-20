package br.com.brovetech.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "nota_fiscal")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NotaFiscal {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    private String xml;
    @Column(name = "data_emissao")
    private Date dataEmissao;

}
