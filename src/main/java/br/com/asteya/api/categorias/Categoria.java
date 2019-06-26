package br.com.asteya.api.categorias;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "categoria")
@EqualsAndHashCode(of = "codigo")
public class Categoria {
    private Long codigo;
    private String nome;
}
