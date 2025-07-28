package local.enrico.Fast_and_Furious_Food.domain.service;

import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import local.enrico.Fast_and_Furious_Food.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enrico
 */

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //================================GET=====================================//
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    //==========================GET_CATEGORIA=================================//
    public List<Produto> findByCategoria(String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }
  
    
    // ==============================PUT======================================//
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    //=============================DELETE=====================================//
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

}
