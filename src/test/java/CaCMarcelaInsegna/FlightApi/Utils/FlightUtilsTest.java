package CaCMarcelaInsegna.FlightApi.Utils;

import CaCMarcelaInsegna.FlightApi.Model.Dolar;
import CaCMarcelaInsegna.FlightApi.Model.Flight;
import CaCMarcelaInsegna.FlightApi.Model.FlightDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FlightUtilsTest {
    @Autowired
    FlightUtils flightUtils;

//test de los metodos en utils

    //METODO FLIGHTMAPPER que trae la lista de vuelos DTO
    @Test

    void flightMapperTest() {

    List<Flight> flightList = new ArrayList<>(); //nueva lista de vuelos
    double dolarPrice = 1020;
    List<FlightDto> flightDtoList;

        Flight flight01 = new Flight(); //crear un nuevo vuelo flight1
        //le seteo los valores a cada atributo
        flight01.setId(1L);
        flight01.setOrigen("COR");
        flight01.setDestino("EZE");
        flight01.setFechaHoraSalida("2024-04-18");
        flight01.setFechaHoraLlegada("2024-04-19");
        flight01.setPrecio(150);
        flight01.setFrecuencia("diaria");

        flightList.add(flight01);//agrego el vuelo creado a la lista

    //contexto
    flightDtoList = flightUtils.flightMapperDto(flightList, dolarPrice);

    FlightDto flightDto = flightDtoList.get(0);
    //espero que el id sea 1 y traigo el id del flight

    //assertEquals(2, flightDto.getId()); este bloque da error en el test porque el esperado es 2 y el id que le pase al vuelo es 1
    assertEquals(1, flightDto.getId());
    assertEquals(flight01.getPrecio() * dolarPrice ,flightDto.getPrecioConvertido());}

    @Test
    void detectarOfertasTest() {

        List<Flight> flightList = new ArrayList<>(); //creo lista de vuelos
        flightList.add(new Flight("AEP", "BAR", "2024-04-10", "2024-04-11", 100.00, "diario"));
        flightList.add(new Flight("AEP", "MEN", "2024-04-11", "2024-04-12", 245.0, "diario"));
        flightList.add(new Flight("IGZ", "AEP", "2024-04-10", "2024-04-11", 170.0, "diario"));

       Integer precioOferta = 145;

       List<Flight> offers = flightUtils.detectarOfertas(flightList, precioOferta); //detecto las ofertas


        assertEquals(1, offers.size());} //comparo
         //assertEquals(2, offers.size());} //esta comparacion da error xq ofertas hay una sola

    @Test
    void fetchDolarTest(){

        FlightUtils mockedFlightUtils =  mock(FlightUtils.class);

        Dolar dummyDolar = new Dolar(); //creo un dolar nuevo y le paso los valores

        dummyDolar.setMoneda("USD");
        dummyDolar.setCasa("tarjeta");
        dummyDolar.setNombre("Tarjeta");
        dummyDolar.setCompra(1100.0);
        dummyDolar.setVenta(1050.0);


        when(mockedFlightUtils.fetchDolar()).thenReturn(dummyDolar);
        //funcionalidad
        Dolar dolarPrueba = mockedFlightUtils.fetchDolar();
        //verificaciones
        assertEquals(1100,dolarPrueba.getPromedio());
         // el test falla porque espera 1075 de promedio u recibo 1100

    }

    }
