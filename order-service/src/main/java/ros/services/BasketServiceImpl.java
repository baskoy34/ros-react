package ros.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.mapper.BasketProductMapper;
import ros.mapper.ProductMapper;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.repositorys.BasketProductRepository;
import ros.repositorys.BasketRepository;
import ros.repositorys.ProductRepository;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
  private ProductMapper productMapper;
  private BasketProductMapper basketProductMapper;
  private final   BasketRepository basketRepository;
  private final ProductRepository productRepository;
  private  final BasketProductRepository basketProductRepository;



    @Override
    public BasketDto getBasket(Long id) {
        //desk client çağır
        return null;
    }

    @Override
    public BasketDto addtoBasket(BasketProductDto basketProductDto) throws Exception {

        Basket basket=basketRepository.findById(basketProductDto.getId()).orElseThrow(Exception::new);
        //Product product=productRepository.findById(productId).orElseThrow(Exception::new);
        //call stock service if quantiy  ok
        BasketProduct basketProduct=basketProductMapper.dtoToBasketProduct(basketProductDto);
        basketProductRepository.save(basketProduct);

        return null;
    }

    @Override
    public BasketDto removeBasketsItem(Long basketId, long productid) {
        return null;
    }

    @Override
    public BasketDto clearBasket(Long basketId) {
        return null;
    }
}
