package br.com.brovetech.ecommerce.model;

import br.com.brovetech.ecommerce.enumeration.SexoClienteEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Table(name = "cliente")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    @Column(name = "sexo_cliente")
    @Enumerated(EnumType.STRING)
    private SexoClienteEnum sexoCliente;
}
