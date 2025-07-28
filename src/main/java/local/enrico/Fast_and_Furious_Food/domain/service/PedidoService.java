/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.enrico.Fast_and_Furious_Food.domain.service;

import jakarta.transaction.Transactional;
import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.ItemPedido;
import local.enrico.Fast_and_Furious_Food.domain.model.Pedido;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import local.enrico.Fast_and_Furious_Food.domain.model.StatusPedido;
import local.enrico.Fast_and_Furious_Food.domain.repository.PedidoRepository;
import local.enrico.Fast_and_Furious_Food.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enrico
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    //================================GET=====================================//
    
    /**
     * Lista todos os pedidos.
     * @return Lista de Pedido.
     */
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
    //==================================POST==================================//

    /**
 * Controla transações de banco de dados, garantindo que operações sejam 
 * executadas como uma única unidade atômica (tudo ou nada).
 * Ou seja, deu erro? Volta tudo
 */    
    
    @Transactional
    public Pedido criar(Pedido pedido) {
        // 1. Configura o pedido
        pedido.setStatus(StatusPedido.ABERTO);

        // 2. Para cada item no ItemPedido o pedido pega ele.
        for (ItemPedido item : pedido.getItens()) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            item.setStatus(StatusPedido.ABERTO);
            item.setPedido(pedido);
            item.setProduto(produto);
            item.setPreco(produto.getPreco());
            item.setTotal(produto.getPreco() * item.getQuantidade());
        }
        
        pedido.getItens().forEach(item -> {
        item.calcularTotal(); // Calcula total de cada item
        });
        // 3. Calcula o total do pedido
        pedido.calcularTudo();

        return pedidoRepository.save(pedido);
    }
    
    //=================================DELETE=================================//
    
    /**
     * Eclui um pedido com base em um id.
     * @param id Identificação do Pedido.
     */
    public void excluir(Long id){
       pedidoRepository.deleteById(id);
        
    }
    //==============================PUT=======================================//
    public Pedido salvar(Pedido pedido) {
    return pedidoRepository.save(pedido);
    }
}

