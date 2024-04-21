package CaCMarcelaInsegna.FlightApi.Exceptions;

public class NameNotFoundException extends IllegalArgumentException{

    public NameNotFoundException(String mesagge){
        super(mesagge);
    }
}
