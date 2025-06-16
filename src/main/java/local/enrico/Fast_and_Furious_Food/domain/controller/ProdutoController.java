package local.enrico.Fast_and_Furious_Food.domain.controller;

import java.util.List;
import java.util.Optional;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import local.enrico.Fast_and_Furious_Food.domain.repository.ProdutoRepository;
import local.enrico.Fast_and_Furious_Food.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastfurious/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    //==============POST===================//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
    
    //=============GET====================//
    
    //==GERAL==//
    @GetMapping
    public List<Produto> listas() {
        return produtoService.findAll(); 
    
    }
    
    //===id===//
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar (@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        
        if(produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        } else {
           return ResponseEntity.notFound().build();
        }
    
    }
    
    //===Categoraia===//
    
    @GetMapping("/cat/{categoria}")
    public List<Produto> findByCategoria(@PathVariable String categoria) {
        return produtoService.findByCategoria(categoria);
    }
    
    //==============PUT==============//
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar (@PathVariable Long id, @RequestBody Produto produto){
        
        if(!produtoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        else {
        
            produto.setId(id);
            
            produto = produtoService.salvar(produto);
            
            return ResponseEntity.ok(produto);
        }
    }
    
    
    //==========DELETE==========//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id) {
    
        if(!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            
            produtoService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        
    }
    
    
    
}
