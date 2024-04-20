package CaCMarcelaInsegna.FlightApi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;
    public String nombre;
    public String banner;
}