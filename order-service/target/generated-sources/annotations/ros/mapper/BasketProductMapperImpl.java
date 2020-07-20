package ros.mapper;

import javax.annotation.Generated;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ros.dtos.BasketProductDto;
import ros.models.BasketProduct;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-20T15:42:24+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class BasketProductMapperImpl extends BasketProductMapper {

    @Override
    public BasketProduct dtoToBasketProduct(BasketProductDto basketProductDto) {
        if ( basketProductDto == null ) {
            return null;
        }

        BasketProduct basketProduct = new BasketProduct();

        try {
            basketProduct.setBasket( toBasket( basketProductDto.getBasketId() ) );
        }
        catch ( EntityNotFoundException e ) {
            throw new RuntimeException( e );
        }
        try {
            basketProduct.setProduct( toProduct( basketProductDto.getProductId() ) );
        }
        catch ( EntityNotFoundException e ) {
            throw new RuntimeException( e );
        }
        basketProduct.setId( basketProductDto.getId() );
        basketProduct.setPiece( basketProductDto.getPiece() );

        return basketProduct;
    }
}
