package CaCMarcelaInsegna.FlightApi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter


public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String nombre;
    public String banner;



}