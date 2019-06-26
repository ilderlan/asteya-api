package br.com.asteya.api.categorias;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    Categoria buscarPeloCodigo(Long codigo) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(codigo);

        if(!optionalCategoria.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }
        return optionalCategoria.get();
    }

    Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    void deletar(Long codigo) {
        categoriaRepository.deleteById(codigo);
    }

    Categoria atualizar(Long codigo, Categoria categoria) {
        Categoria categoriaSalva = this.buscarPeloCodigo(codigo);
        BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
        categoriaRepository.save(categoriaSalva);
        return categoriaSalva;
    }
}
