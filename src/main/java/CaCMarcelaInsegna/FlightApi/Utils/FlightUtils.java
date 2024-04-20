package CaCMarcelaInsegna.FlightApi.Utils;

import CaCMarcelaInsegna.FlightApi.Model.Dolar;
import CaCMarcelaInsegna.FlightApi.Model.Flight;
import CaCMarcelaInsegna.FlightApi.Model.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class FlightUtils {
    public List<Flight> detectOffers(List<Flight> flights, Integer offerPrice) {
        /*List<Flight> vuelosOferta = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getPrecio() < precioOferta) {
                vuelosOferta.add(flight);
            }
        } return vuelosOferta;
        hasta aca si pasamos el precio a mano*/

        /*con programacion funcional
        filtra los precios segun la oferta deseada*/

        return flights.stream()
                .filter(flight -> flight.getPrecio()<offerPrice).
                collect(Collectors.toList());
    }
    //metodo que trae un vuelo
//    public FlightDto flightMapper(Flight flight,double price){ //price es el precio promedio para convertir a pesos
//        return new FlightDto(flight.getId(),flight.getOrigen(), flight.getDestino(),
//                flight.getFechaHoraSalida(), flight.getFechaHoraLlegada(),
//                flight.getPrecio() * price, flight.getFrecuencia());
//    }
    //metodo que trae una lista de vuelos
    public static List<FlightDto>flightMapper(List<Flight> flights, double dolarPrice) {
        List<FlightDto> flightDtos = new ArrayList<>(); //inicializa una lista vacia de flight Dto
        for (Flight flight : flights) { //recorre la lista de vuelos
            flightDtos.add(new FlightDto(flight.getId(), flight.getOrigen(), flight.getDestino(), // agrega cada vuelo como dto
                    flight.getFechaHoraSalida(), flight.getFechaHoraLlegada(),
                    flight.getPrecio() * dolarPrice, flight.getFrecuencia())); // con la conversion a pesos
        }
        return flightDtos;
    }

    //@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //me devuelve el dolar como objeto
    public Dolar fetchDolar() {
        RestTemplate restTemplate = restTemplate(); //restTemplate indica que se usa elementos externos, API
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        //solicitud a esa ruta y la clase que voy a usar para es consulta
        return restTemplate.getForObject(apiUrl, Dolar.class);

    }
    public Dolar[] fetchAllDolars(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares";
        return restTemplate.getForEntity(apiUrl, Dolar[].class).getBody(); //trae el objeto pasando url y la clase


    }
}