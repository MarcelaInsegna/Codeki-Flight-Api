package CaCMarcelaInsegna.FlightApi.Configuration;

import CaCMarcelaInsegna.FlightApi.Model.Dolar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FlightConfiguration {
    @Bean
    //metodo que devuelve una instancia de RestTemplate
    public RestTemplate restTemplate (){ //restTemplate es el modelo mas sencillo de acceder a una api
        return new RestTemplate();
    }

    public Dolar fetchDolar(){ //metodo que retorna el dolar como objeto
        RestTemplate restTemplate=restTemplate(); //inyecta restTemplate, comunicacion externa
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta"; //ruta de la appi
        return restTemplate.getForObject(apiUrl, Dolar.class); //retona por medio de get el objeto pasando url y clase
    }
    public Dolar[] fetchAllDolars(){
        RestTemplate restTemplate=restTemplate(); //inyecta restTemplate, comunicacion externa
        String apiUrl = "https://dolarapi.com/v1/dolares"; //ruta de la appi
        return restTemplate.getForEntity(apiUrl,Dolar[].class).getBody();
    }
}
