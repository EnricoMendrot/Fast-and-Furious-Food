/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.enrico.Fast_and_Furious_Food.domain.repository;

import java.util.Optional;
import local.enrico.Fast_and_Furious_Food.domain.model.Pedido;
import local.enrico.Fast_and_Furious_Food.domain.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enrico
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
   /**
    * Responsável por buscar os pedidos com um Status em específico.
    * @param status Status dos pedidos
    * @return 
    */
    Optional<Pedido> findByStatus (StatusPedido status);
}
