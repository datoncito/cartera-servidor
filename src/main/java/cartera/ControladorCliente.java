package cartera;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by campitos on 4/24/15.
 */

@Controller
public class ControladorCliente {
    @Inject
    ServicioCliente servicioCliente;

    @RequestMapping(value="/cliente", method= RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody
    String guardarCliente(){
           Direccion direccion=new Direccion();
        direccion.setColonia("San Agus");
        direccion.setCp(55130l);
        direccion.setEstado("Mexico");
        direccion.setMunicipio("Ecatepec");
        Cliente cliente=new Cliente();
        cliente.setDireccion(direccion);
        cliente.setEdad(42);
        cliente.setEmail("rapidclimate@gmail.com");
        cliente.setSueldo(70000f);
        servicioCliente.guardarCliente(cliente);
        return "Cliente guardado con exito";
    }
}
