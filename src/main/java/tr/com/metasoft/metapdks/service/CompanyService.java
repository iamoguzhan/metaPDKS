package tr.com.metasoft.metapdks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.metasoft.metapdks.model.Company;
import tr.com.metasoft.metapdks.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    final
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }

    //get all employees
    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    //get an employee by id
    public Company getById(String id){
        return companyRepository.findById(id).orElse(null);
    }

    //delete an employee
    public void delete(Company company){
        companyRepository.delete(company);
    }

    //get a company with company name
    public List<Company> getByCompany(String company){
        return companyRepository.findByCompanyName(company);
    }

}
