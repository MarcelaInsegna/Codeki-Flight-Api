package CaCMarcelaInsegna.FlightApi.Repository;

import CaCMarcelaInsegna.FlightApi.Model.Company;
import CaCMarcelaInsegna.FlightApi.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository  extends JpaRepository <Company, Long> {
    Optional <Company> findByNombre(String nombre);
}
