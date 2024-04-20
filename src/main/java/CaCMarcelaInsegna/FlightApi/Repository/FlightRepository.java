package CaCMarcelaInsegna.FlightApi.Repository;

import CaCMarcelaInsegna.FlightApi.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOrigen(String origen);
    List <Flight> getByOrigenAndDestino(String origen, String destino);
}
