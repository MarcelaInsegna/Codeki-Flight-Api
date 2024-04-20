package CaCMarcelaInsegna.FlightApi.Service;

import CaCMarcelaInsegna.FlightApi.Configuration.FlightConfiguration;
import CaCMarcelaInsegna.FlightApi.Utils.FlightUtils;
import CaCMarcelaInsegna.FlightApi.Model.Dolar;
import CaCMarcelaInsegna.FlightApi.Model.Flight;
import CaCMarcelaInsegna.FlightApi.Model.FlightDto;
import CaCMarcelaInsegna.FlightApi.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired  //inyeccion del repositorio
    FlightRepository flightRepository;

    public List<Flight> traerTodosLosVuelos() {
        return flightRepository.findAll();}

    public void crearVuelo(Flight flight){
        flightRepository.save(flight);
    }
    public Flight buscarVueloPorId(Long id) {
        return flightRepository.findById(id).orElse(null);
        // return vueloRepository.findById(id);  error porque puede devolver
        // un null si el id a buscar no existe
    }
    public void borrarVueloPorId(Long id) {
        flightRepository.deleteById(id);
    }
    public Flight actualizarVuelo(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId()).orElse(null);
    }
    public List<Flight> traerPorOrigen(String origen){
        return flightRepository.findByOrigen(origen);
    }
    public  List<Flight> traerPorOrigenDestino(String origen, String destino){
        return flightRepository.getByOrigenAndDestino(origen, destino);
    }
    @Autowired
    FlightUtils flightUtils;

    public List<FlightDto> traerLosVuelosDto(){
        double dolarPrice = getDolar();
        List<Flight> flights =flightRepository.findAll();
        return FlightUtils.flightMapper(flights,dolarPrice);}

    @Autowired
    FlightConfiguration flightConfiguration;

    private double getDolar() {
        return flightConfiguration.fetchDolar() //esta linea devuelve el dolar
                .getPromedio();
        //Dolar dolar = flightConfiguration.fetchDolar();
        //return dolar.getPromedio();    es lo mismo que la linea de arriba del return
    }

    public List<Dolar> traerTodosLosDolars() {
        return List.of(flightConfiguration.fetchAllDolars());
    }
}








// ANOTACIONES EXTRAS

//Este bloque crea una lista pero debe llamarse en cada accion

//    creamos una lista
//    private List<Flight> flightList = new ArrayList<>();

//    creamos los vuelos
//    Flight flight1 = new Flight(1L,"Puerto Madryn", "Cordoba", "24-02-2024","25-02-2024",200.00, "mensual");
//    Flight flight2 = new Flight(2L,"Madryn", "Cordoba", "24-02-2024","25-02-2024",300.00, "diaria");
//    Flight flight3 = new Flight(3L,"Puerto ", "Cordoba", "24-02-2024","25-02-2024",400.00, "semanal");
//


//para crear una lista una sola vez se hace de la sig manera

//    private List<Flight> flightList = Arrays.asList(
//            new Flight(1L,"Puerto Madryn","Cordoba","24-02-2024","25-02-2024",200.00, "mensual"),
//            new Flight(2L,"Madryn","Cordoba Capital","25-02-2024","26-02-2024",300.00, "diaria"),
//            new Flight(3L,"Puerto","Cordoba Provincia","26-02-2024","27-02-2024",400.00, "anual")
//    );