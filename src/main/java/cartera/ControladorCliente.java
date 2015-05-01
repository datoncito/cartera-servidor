package cartera;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by campitos on 4/24/15.
 */

@Controller
public class ControladorCliente {
    @Inject
    ServicioCliente servicioCliente;


    //GET ALL
    @RequestMapping(value="/cliente", method=RequestMethod.GET, headers={"Accept=application/json;charset=UTF-8"})
     @ResponseBody String buscarTodos()throws Exception{
      ObjectMapper maper=new ObjectMapper();
             System.out.println(servicioCliente.buscarTodos().get(0).getFecha().toString());
        return maper.writeValueAsString(servicioCliente.buscarTodos());
    }

    //GET POR ID
    @RequestMapping(value="/cliente/{id}", method=RequestMethod.GET, headers={"Accept=application/json;charset=UTF-8"})
    @ResponseBody String buscarporId(@PathVariable String id)throws Exception{
        ObjectMapper maper=new ObjectMapper();
        Cliente cli=new Cliente();
        cli.setSueldo(4000f);
        cli.setNombre("Juan Carlos");
        System.out.println("<<<<<<<<<<<SE ACTIVO EL GET POR ID  ");
        return maper.writeValueAsString(cli);
    }

    //POST
    @RequestMapping(value="/cliente", method= RequestMethod.POST, headers={"Accept=application/json;charset=UTF-8"})
    @ResponseBody
    String guardarCliente(@RequestBody String json)throws Exception{
ObjectMapper mapper=new ObjectMapper();

        //convertimos jsonsito a un Cliente, que asi se supone vienen :)
        Cliente cli = mapper.readValue(json,Cliente.class );

        System.out.println("<<<<METODO POST CON EXITOcon nombre " + cli.getNombre() + " Y su estado es:" + cli.getDireccion().getEstado()
                + " y su municipio es " + cli.getDireccion().getMunicipio());

           Direccion direccion=new Direccion();
        direccion.setColonia("San Agus");
        direccion.setCp(55130l);
        direccion.setEstado("Mexico");
        direccion.setMunicipio("Ecatepec");
        Cliente cliente=new Cliente();
        cliente.setDireccion(direccion);
        cliente.setEdad(42);
        cliente.setFecha(DateTime.now());
        cliente.setEmail("rapidclimate@gmail.com");
        cliente.setSueldo(70000f);
       // servicioCliente.guardarCliente(cliente);
        return mapper.writeValueAsString(cli);
    }

    @RequestMapping(value="/cliente", method=RequestMethod.PUT, headers={"Accept=application/json;charset=UTF-8"})
    @ResponseBody
    String actualizarCliente(@RequestBody String json )throws Exception{
        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();
        //convert JSON string to Map

        map = mapper.readValue(json,
                new TypeReference<HashMap<String,String>>(){});


        System.out.println("<<<<METODO PUT CON EXITOcon nombre "+map.get("id")+ " y sueldo "+map.get("nombre"));


        return mapper.writeValueAsString(map);
    }

    @RequestMapping(value="/cliente/{id}", method=RequestMethod.DELETE, headers={"Accept=text/html"})
    public @ResponseBody String borrarProducto(@PathVariable String id)throws Exception{



        System.out.println("se activooooooo el DELETE exitosamente con id:"+id);
        //Le desdoblamos el id

        //   String algo= servicioProducto.borrarProducto(id);


        return "gg";
    }



}
