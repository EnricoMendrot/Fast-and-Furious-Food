package local.enrico.Fast_and_Furious_Food.domain.repository;

import local.enrico.Fast_and_Furious_Food.domain.model.ItemPedido;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enrico
 */
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
    
}
