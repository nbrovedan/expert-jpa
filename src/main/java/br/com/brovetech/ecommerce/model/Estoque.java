package br.com.brovetech.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "estoque")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estoque {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @Column(name = "produto_id")
    private Integer produtoId;
    private Integer quantidade;

}
