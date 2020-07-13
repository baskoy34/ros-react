package ros.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ros.dtos.BasketProductDto;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-13T21:52:16+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class BasketProductMapperImpl implements BasketProductMapper {

    @Override
    public List<BasketProduct> dtoListToEntityList(List<BasketProductDto> basketProductDtos) {
        if ( basketProductDtos == null ) {
            return null;
        }

        List<BasketProduct> list = new ArrayList<BasketProduct>( basketProductDtos.size() );
        for ( BasketProductDto basketProductDto : basketProductDtos ) {
            list.add( dtoToBasketProduct( basketProductDto ) );
        }

        return list;
    }

    @Override
    public BasketProduct dtoToBasketProduct(BasketProductDto basketProductDto) {
        if ( basketProductDto == null ) {
            return null;
        }

        BasketProduct basketProduct = new BasketProduct();

        basketProduct.setProduct( basketProductDtoToProduct( basketProductDto ) );
        basketProduct.setBasket( basketProductDtoToBasket( basketProductDto ) );
        basketProduct.setId( basketProductDto.getId() );
        basketProduct.setPiece( basketProductDto.getPiece() );

        return basketProduct;
    }

    protected Product basketProductDtoToProduct(BasketProductDto basketProductDto) {
        if ( basketProductDto == null ) {
            return null;
        }

        Product product = new Product();

        if ( basketProductDto.getBasketId() != null ) {
            product.setId( basketProductDto.getBasketId() );
        }

        return product;
    }

    protected Basket basketProductDtoToBasket(BasketProductDto basketProductDto) {
        if ( basketProductDto == null ) {
            return null;
        }

        Basket basket = new Basket();

        if ( basketProductDto.getBasketId() != null ) {
            basket.setId( basketProductDto.getBasketId() );
        }

        return basket;
    }
}
