package br.com.asteya.api.lancamentos;

import br.com.asteya.api.categorias.Categoria;
import br.com.asteya.api.tags.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(of = "codigo")
public class Lancamento {
    private Long codigo;
    private LocalDateTime creacao;
    private LocalDate vencimento;
    private String descricao;
    private List<Tag> tags;
    private Categoria categoria;
    private Long numeroDeRepeticoes;
}
