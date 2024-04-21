package CaCMarcelaInsegna.FlightApi.Repository;

import CaCMarcelaInsegna.FlightApi.Model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;


    private Flight flight;

    @BeforeEach
    void setup(){
        flight = new Flight("IGZ", "AEP","2024-04-20","2024-04-21",145.0,"diario");
    }

    @Test
    void saveFlightTest(){
        //configuracion previa

        //Llamar la funcionalidad
        Flight flightBD = flightRepository.save(flight);

        assertThat(flightBD).isNotNull(); //comparo
        assertThat(flightBD.getId()).isGreaterThan(0);
    }

    @Test
    void flightFindByIdTest(){
        //configuracion previa
        flightRepository.save(flight);
        //Llamar la funcionalidad
        Flight flightBD = flightRepository.findById(flight.getId()).get();

        assertThat(flightBD).isNotNull(); //comparo
    }

    @Test
    void flightFindAllTest(){
        //configuracion previa
        Flight flight2 = new Flight("MAD", "COR","8.00","11.00",200.0,"Diaria");

        flightRepository.save(flight);
        flightRepository.save(flight2);

        //Llamar la funcionalidad
        List<Flight> flightList = flightRepository.findAll();

        //verificar la salida o el comportamiento
        assertThat(flightList).isNotNull();
        assertThat(flightList.size()).isEqualTo(2);
    }

    @Test
    void flightDeleteById(){
        //configuracion previa
        flightRepository.save(flight);
        //llamar la funcionalidad
        flightRepository.deleteById(flight.getId());

        // verificar la salidad o el comportamiento
        Optional<Flight> deletedFlight = flightRepository.findById(flight.getId());
        assertThat(deletedFlight).isEmpty();
    }

    @Test
    void flightUpdateTest(){
        flightRepository.save(flight);
        Flight flightBD = flightRepository.findById(flight.getId()).get();

        flightBD.setOrigen("IGZ");
        flightBD.setDestino("EZE");

        Flight flightUpdated = flightRepository.save(flightBD);

        assertThat(flightUpdated.getOrigen()).isEqualTo("BRA");
        assertThat(flightUpdated.getDestino()).isEqualTo("ARG");
        //Este test falla porque espera "BRA" y recibe "IGZ"
    }
}
