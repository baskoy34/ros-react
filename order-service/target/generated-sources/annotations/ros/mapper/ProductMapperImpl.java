package ros.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ros.dtos.ProductDto;
import ros.models.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-13T20:01:53+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productToProductdto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        return productDto;
    }
}
