package local.enrico.Fast_and_Furious_Food.domain.controller;

import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.Pedido;
import local.enrico.Fast_and_Furious_Food.domain.repository.PedidoRepository;
import local.enrico.Fast_and_Furious_Food.domain.service.PedidoService;
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
    private PedidoRepository pedidoRepository;
    
    //================================GET=====================================//
    @GetMapping
        public List<Pedido> listas(){
        List<Pedido> pedidos = pedidoRepository.findAll();
            pedidos.forEach(pedido -> 
        pedido.getItens().forEach(item -> item.setStatus(pedido.getStatus())));
        return pedidos;
    }
        
}

