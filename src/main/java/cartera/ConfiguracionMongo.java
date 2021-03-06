package cartera;

/**
 * Created by campitos on 4/24/15.
 */

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class ConfiguracionMongo extends AbstractMongoConfiguration {
    /*
     * Lo interesante aqui es que en spring la anotacion Bean del primer bean MongoDbFactory
     * esta enlazado con el de abajo que es el MongoTemplate, ya que este ultimo requiere
     * para que se cree en su constructor la referencia de tipo MongoDbFactory
     * ya posteriormente podremos invocar directamente MongoTemplate mongoTemplate (con
     * su respectiva anotacion @Autowired) dentro de nuestro controller para hacer uso
     * del mongoTemplate y todas esas hermosas operaciones.
     */
    public @Bean
    SimpleMongoDbFactory mongoDbFactory() throws Exception{
        //MongoURI uri=new MongoURI("mongodb://campitos:celiesita@paulo.mongohq.com:10017/htxiBv8O8SYnF8rGqmUQhw");
        MongoURI uri=new MongoURI("mongodb://campitos-gcm:celiesita@paulo.mongohq.com:10037/campitos-base");

        return new SimpleMongoDbFactory(uri);

    }
    public @Bean
    GridFsTemplate gridFsTemplate() throws Exception{
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }



    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mongo mongo() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}