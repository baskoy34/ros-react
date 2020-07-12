package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.CategoryDto;
import ros.models.Category;
import ros.repositorys.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements IGenericService<CategoryDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryDto findById(long id) {
        Category category = categoryRepository.findById(id).get();
        if(category != null)
            return modelMapper.map(category,CategoryDto.class);
        else
            return null;
    }

    @Override
    public void deleteById(long id) {
        Category category = categoryRepository.findById(id).get();
        if(category != null){
            category.setActive(false);
            categoryRepository.save(category);
        }
        else{
            // yakında
        }

    }

    @Override
    public CategoryDto Update(CategoryDto entity) {
        Category category = modelMapper.map(entity,Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAll(long id) {
        List<Category> categories = categoryRepository.findAllByStore(id);
        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();

        for (Category category:categories) {
            categoryDtos.add(modelMapper.map(category,CategoryDto.class));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto Add(CategoryDto entity) {
        Category category = modelMapper.map(entity,Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category,CategoryDto.class);
    }
}
