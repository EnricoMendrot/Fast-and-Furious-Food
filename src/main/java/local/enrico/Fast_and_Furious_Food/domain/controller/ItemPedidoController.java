package local.enrico.Fast_and_Furious_Food.domain.controller;

import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import local.enrico.Fast_and_Furious_Food.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Enrico
 */
@RestController
@RequestMapping("/fastfurious/pedido")
public class ItemPedidoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    //==============GET=================//
    @GetMapping
        public List<Produto> listas(){
        return produtoService.findAll();
    }
        
}

