package CaCMarcelaInsegna.FlightApi.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")//que direcciones que puede acceder
                .allowedOrigins("*") // quien puede acceder
                .allowedMethods("GET","POST","PUT","DELETE") //que metodos http puede ejecutar
                .allowedHeaders("*"); //seguridad y traspaso de info. pares de clave valor(map)
    }
}

