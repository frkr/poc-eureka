package poc.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import poc.data.jpa.Cliente;

@RepositoryRestResource(collectionResourceRel = "cliente", path = "cliente")
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

}
