package local.enrico.Fast_and_Furious_Food.domain.repository;

import java.util.List;
import local.enrico.Fast_and_Furious_Food.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enrico
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
      
    List<Produto> findByCategoria(String categoria);
}
