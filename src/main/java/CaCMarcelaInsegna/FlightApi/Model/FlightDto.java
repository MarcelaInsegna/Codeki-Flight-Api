package CaCMarcelaInsegna.FlightApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private String origen;
    private String destino;
    private String FechaHoraSalida;
    private String FechaHoraLlegada;
    private double precioConvertido;
    private String frecuencia;
}