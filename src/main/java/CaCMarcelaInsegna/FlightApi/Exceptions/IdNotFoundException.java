package CaCMarcelaInsegna.FlightApi.Exceptions;

public class IdNotFoundException extends  IllegalArgumentException{

    public IdNotFoundException(String message) {
        super(message);
    }
}
