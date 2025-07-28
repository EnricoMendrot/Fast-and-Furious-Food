/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.enrico.Fast_and_Furious_Food.domain.repository;

import local.enrico.Fast_and_Furious_Food.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enrico
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
   
}
