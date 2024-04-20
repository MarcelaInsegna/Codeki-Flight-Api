package CaCMarcelaInsegna.FlightApi.Controller;

import CaCMarcelaInsegna.FlightApi.Model.Flight;
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

}
