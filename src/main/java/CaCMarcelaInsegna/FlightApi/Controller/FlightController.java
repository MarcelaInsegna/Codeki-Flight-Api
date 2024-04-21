package CaCMarcelaInsegna.FlightApi.Controller;

import CaCMarcelaInsegna.FlightApi.Model.Flight;
import CaCMarcelaInsegna.FlightApi.Model.FlightDto;
import CaCMarcelaInsegna.FlightApi.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")

public class FlightController {
    @Autowired
    FlightService flightService; //se inyecta desde el Service

    @GetMapping("")
    public List<Flight> traerVuelos(){
        return flightService.traerTodosLosVuelos();
    }

    @GetMapping("/vuelosDto")
    public List<FlightDto> traerVuelosDto(){
        return flightService.traerLosVuelosDto();
    }

    @PostMapping("/crear")
    public void crearUnVuelo (@RequestBody Flight flight){
        flightService.crearVuelo(flight);
    }

    @GetMapping("/{id}") // las {} sirven para indicar que es un parametro
    public Flight buscarPorId(@PathVariable Long id){
        return flightService.buscarVueloPorId(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPorId (@PathVariable Long id) {
        flightService.borrarVueloPorId(id);
    }

    @PutMapping("/actualizar")
    public Flight actualizarUnVuelo (@RequestBody Flight flight) {
        return flightService.actualizarVuelo(flight);
    }

    @GetMapping("/origen")
    public List<Flight> vueloPorOrigen (@RequestParam String origen){
        return flightService.traerPorOrigen(origen);
    }

    @GetMapping("/origen-destino")
    public List<Flight> vueloPorOrigenDestino (@RequestParam String origen, @RequestParam String destino){
        return flightService.traerPorOrigenDestino(origen, destino);
    }


    //    CONSULTA CON VALOR DE OFERTA ESTABLECIDO
//    @GetMapping("/ofertas")
//    public List<Flight> getOffers(){
//        Integer offerPrice = 200;
//        return  flightService.traerOfertas(offerPrice);
//    }
    //CONSULTA CON VALOR PASADO POR PARAMETRO
    @GetMapping("/ofertas/{precioOferta}")
    public List<Flight> getOffers(@PathVariable Integer precioOferta){
        return flightService.traerOfertas(precioOferta);
    }



}
