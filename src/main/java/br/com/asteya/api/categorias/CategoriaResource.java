package br.com.asteya.api.categorias;

import br.com.asteya.api.event.RecursoCriadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok(categoriaService.listar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
        return ResponseEntity.ok(categoriaService.buscarPeloCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaService.salvar(categoria);
        applicationEventPublisher.publishEvent(new RecursoCriadoEvent(this, categoria.getCodigo(), response));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long codigo){
        categoriaService.deletar(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria){
        Categoria alunoSalvo = categoriaService.atualizar(codigo, categoria);
        return ResponseEntity.ok(alunoSalvo);
    }
}
