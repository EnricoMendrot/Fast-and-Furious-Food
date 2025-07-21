/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.enrico.Fast_and_Furious_Food.domain.controller;

import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.ItemPedido;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import local.enrico.Fast_and_Furious_Food.domain.service.ItemPedidoService;
import local.enrico.Fast_and_Furious_Food.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjata
 */
@RestController
@RequestMapping("/fastfurious")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
        public List<Produto> listas(){
        return produtoService.findAll();
    }
    
    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedido criar (@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.criar(itemPedido);
    }
    
}

