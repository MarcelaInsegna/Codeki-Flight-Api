package CaCMarcelaInsegna.FlightApi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity

public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String origen;
    private String destino;
    private String FechaHoraSalida;
    private String FechaHoraLlegada;
    private double precio;
    private String frecuencia;

    //constructor completo

    public Flight(Long id, String origen, String destino, String fechaHoraSalida, String fechaHoraLlegada, double precio, String frecuencia) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        FechaHoraSalida = fechaHoraSalida;
        FechaHoraLlegada = fechaHoraLlegada;
        this.precio = precio;
        this.frecuencia = frecuencia;
    }

    //constructor sin ID

    public Flight(String origen, String destino, String fechaHoraSalida, String fechaHoraLlegada, double precio, String frecuencia) {
        this.origen = origen;
        this.destino = destino;
        FechaHoraSalida = fechaHoraSalida;
        FechaHoraLlegada = fechaHoraLlegada;
        this.precio = precio;
        this.frecuencia = frecuencia;
    }
    // getter y setter de todos los atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaHoraLlegada() {
        return FechaHoraLlegada;
    }

    public void setFechaHoraLlegada(String fechaHoraLlegada) {
        FechaHoraLlegada = fechaHoraLlegada;
    }

    public String getFechaHoraSalida() {
        return FechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        FechaHoraSalida = fechaHoraSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }
}
