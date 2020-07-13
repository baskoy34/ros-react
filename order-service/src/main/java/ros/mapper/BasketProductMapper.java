package ros.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ros.dtos.BasketProductDto;
import ros.models.BasketProduct;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketProductMapper {
    List<BasketProduct>dtoListToEntityList(List<BasketProductDto>basketProductDtos);
    @Mappings({
            @Mapping(target ="product.id",source = "basketProductDto.basketId"),
            @Mapping(target = "basket.id",source = "basketProductDto.basketId")
    })
    BasketProduct dtoToBasketProduct(BasketProductDto basketProductDto);
}
