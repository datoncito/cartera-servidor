package cartera;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by campitos on 4/24/15.
 */
@Repository
public class ServicioCliente {
    @Inject
    private MongoTemplate mongoTemplate;

    public void guardarCliente(Cliente c){
        if(!mongoTemplate.collectionExists(Cliente.class)){
            mongoTemplate.createCollection(Cliente.class);
        }
        mongoTemplate.insert(c);
    }

    public List<Cliente> buscarTodos(){
      List<Cliente> clientes=  mongoTemplate.findAll(Cliente.class);

        return clientes;
    }
}
