package CaCMarcelaInsegna.FlightApi.Service;

import CaCMarcelaInsegna.FlightApi.Exceptions.IdNotFoundException;
import CaCMarcelaInsegna.FlightApi.Exceptions.NameNotFoundException;
import CaCMarcelaInsegna.FlightApi.Exceptions.ResourceNotFoundException;
import CaCMarcelaInsegna.FlightApi.Model.Company;
import CaCMarcelaInsegna.FlightApi.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> traerTodasLasCompanias() {
        return companyRepository.findAll();
    }
    public void crearComania(Company company){
        companyRepository.save(company);
    }
    public Company buscarCompaniaPorId (Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new IdNotFoundException(("No se encontró la compañía con el ID: " + id)));
    }
    public Company buscarCompaniaPorNombre (String nombre) {
        return companyRepository.findByNombre(nombre).
                orElseThrow(()-> new NameNotFoundException(("No se encontro la compania con el nombre: " + nombre)));
    }


    public void borrarCompaniaPorId (Long id) {
         companyRepository.deleteById(id);
     }
    public Company actulizarCompania (Company company) {
        companyRepository.save(company);
                return companyRepository.findById(company.getId()).orElse(null);
    }


}
