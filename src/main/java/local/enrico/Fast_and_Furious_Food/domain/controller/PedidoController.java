package local.enrico.Fast_and_Furious_Food.domain.controller;

import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.Pedido;
import local.enrico.Fast_and_Furious_Food.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Enrico
 */

@RestController
@RequestMapping("/fastfurious/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

   @PostMapping
    public ResponseEntity<?> criar(@RequestBody Pedido itemPedido) {
        try {
            Pedido pedidoSalvo = pedidoService.criar(itemPedido);
            return ResponseEntity.ok(pedidoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


