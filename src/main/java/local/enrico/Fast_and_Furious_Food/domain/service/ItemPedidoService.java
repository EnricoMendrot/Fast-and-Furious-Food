/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.enrico.Fast_and_Furious_Food.domain.service;

import jakarta.persistence.EntityNotFoundException;
import local.enrico.Fast_and_Furious_Food.domain.model.ItemPedido;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import local.enrico.Fast_and_Furious_Food.domain.model.StatusPedido;
import local.enrico.Fast_and_Furious_Food.domain.repository.ItemPedidoRepository;
import local.enrico.Fast_and_Furious_Food.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemPedidoService {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
        
    @Autowired
    private ProdutoRepository produtoRepository; // Se necessário para validação

    public ItemPedido criar(ItemPedido itemPedido) {
    // 1. Valida se o produto existe
    if (itemPedido.getProduto() == null) {
        throw new IllegalArgumentException("O item de pedido deve estar vinculado a um produto existente.");
    }

    // 2. Busca o produto no banco (ou lança exception se não existir)
    Produto produto = produtoRepository.findById(itemPedido.getProduto().getId())
        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + itemPedido.getProduto().getId()));

    // 3. Configurações automáticas
    itemPedido.setStatus(StatusPedido.ABERTO); // Define status padrão
    itemPedido.setProduto(produto); // Garante a referência correta
    itemPedido.calcularTotal();

    return itemPedidoRepository.save(itemPedido);
}

    }

