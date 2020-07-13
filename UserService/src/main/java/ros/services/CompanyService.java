package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ros.dtos.CompanyDto;
import ros.models.Company;
import ros.repositorys.CompanyRepository;

import java.util.List;

public class CompanyService implements IGenericService<CompanyDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto findById(long id) {
        Company company = companyRepository.findById(id).get();
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public CompanyDto Update(CompanyDto entity) {
        return null;
    }

    @Override
    public List<CompanyDto> findAll() {
        return null;
    }

    @Override
    public CompanyDto Add(CompanyDto entity) {
        return null;
    }
}
