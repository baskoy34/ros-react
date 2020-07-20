package ros.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.mapper.BasketMapper;
import ros.mapper.BasketProductMapper;
import ros.mapper.ProductMapper;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Product;
import ros.repositorys.BasketProductRepository;
import ros.repositorys.BasketRepository;
import ros.repositorys.ProductRepository;
import ros.response.AddtoCartResponse;

import java.util.List;
import java.util.Optional;

@Service

public class BasketServiceImpl implements BasketService {
  private ProductMapper productMapper;
  @Autowired
  private BasketMapper basketMapper;
  @Autowired
  private BasketProductMapper basketProductMapper;
  @Autowired
  private   BasketRepository basketRepository;
  @Autowired
  private  ProductRepository productRepository;
  @Autowired
  private   BasketProductRepository basketProductRepository;



    @Override
    public BasketDto getBasket(Long id) {
        //desk client çağır
        Basket basket=basketRepository.findById(id).get();
        return basketMapper.toBasketDto(basket);
    }
    public Optional<Basket>findById(Long id){
        return basketRepository.findById(id);
    }

    @Override
    public AddtoCartResponse addtoBasket(BasketProductDto basketProductDto) throws Exception {

        Basket basket=basketRepository.findById(basketProductDto.getBasketId()).orElseThrow(Exception::new);
        Product product=productRepository.findById(basketProductDto.getProductDto().getId()).orElseThrow(Exception::new);
        //basket.setTotalPrice(basket.getTotalPrice()+product.getPrice());
        //call stock service if quantiy  ok
        BasketProduct basketProduct=new BasketProduct();
        basketProduct.setBasket(basket);
        basketProduct.setProduct(product);
        basketProduct.setPiece(basketProductDto.getPiece());

        basketProductRepository.save(basketProduct);
        // remove gelince sil
        basket.setTotalPrice(gettotalPrice(basket.getBasketProducts()));
        basket=basketRepository.save(basket);

        AddtoCartResponse response =new AddtoCartResponse();
        response.setBasketId(basket.getId());
        response.setItemCount(basket.getBasketProducts().size());
        response.setTotalPrice(basket.getTotalPrice());
        return response;
    }

    @Override
    public BasketDto removeBasketsItem(Long basketId, long productid) {
        return null;
    }

    @Override
    public BasketDto clearBasket(Long basketId) {
        return null;
    }

    public  double gettotalPrice(List<BasketProduct> basketProducts){
        if (basketProducts.size()==0)
            return 0;
        if (basketProducts.size()==1)
            return basketProducts.get(0).getProduct().getPrice()*basketProducts.get(0).getPiece();
       return basketProducts.stream().mapToDouble(p-> p.getPiece()*p.getProduct().getPrice()).reduce(0,(y,x)-> y+x );
    }
}
