package ros.services;

import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.dtos.ProductDto;

public interface BasketService {
    BasketDto getBasket(Long id);
    BasketDto addtoBasket(BasketProductDto basketProductDto) throws Exception;
    BasketDto removeBasketsItem(Long basketId,long productid);
    BasketDto clearBasket(Long basketId);
}
