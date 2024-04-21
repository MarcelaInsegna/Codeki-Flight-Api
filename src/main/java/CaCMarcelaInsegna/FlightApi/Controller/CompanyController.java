package CaCMarcelaInsegna.FlightApi.Controller;

import CaCMarcelaInsegna.FlightApi.Model.Company;
import CaCMarcelaInsegna.FlightApi.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companias")

public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> traerCompanias(){
        return companyService.traerTodasLasCompanias();
    }
    @PostMapping("/crear")
    public void crearCompania (@RequestBody Company company){
        companyService.crearComania(company);
    }
    @GetMapping("/id/{id}")
    public Company buscarCompPorId(@PathVariable Long id){
        return companyService.buscarCompaniaPorId(id);
    }
    @GetMapping("/nombre/{nombre}")
    public Company buscarCompPorNombre(@PathVariable String nombre){
        return (Company) companyService.buscarCompaniaPorNombre(nombre);
    }
    @DeleteMapping("/borrar/{id}")
    public void borrarCompPorId(@PathVariable Long id){
     companyService.borrarCompaniaPorId(id);
    }
    @PutMapping("/actualizar")
    public Company actualizarCompania(@RequestBody Company company) {
        return companyService.actulizarCompania(company);
    }



}
