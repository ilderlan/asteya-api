package br.com.asteya.api.tags;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "codigo")
@Entity
@Table(name = "tag")
public class Tag {
    private Long codigo;
    private String nome;
}
