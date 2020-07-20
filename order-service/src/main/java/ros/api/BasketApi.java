package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.models.Basket;
import ros.models.Product;
import ros.repositorys.BasketRepository;
import ros.repositorys.ProductRepository;
import ros.response.AddtoCartResponse;
import ros.services.BasketServiceImpl;

import java.util.List;

@RequestMapping("/basket")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BasketApi {
  private final   BasketServiceImpl basketService;
  private final ProductRepository productRepository;
    @PostMapping
  public ResponseEntity<AddtoCartResponse>addToBasket(@RequestBody BasketProductDto basketProductDto){
        AddtoCartResponse cartResponse =null;
        System.out.println(basketProductDto);
      try {
          cartResponse = basketService.addtoBasket(basketProductDto);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return ResponseEntity.ok(cartResponse);
  }
  @GetMapping("/item")
  public ResponseEntity<List<Product>>getItems(){
      return ResponseEntity.ok(productRepository.findAll());
  }

    @GetMapping
  public  ResponseEntity<BasketDto>getBasket(){
        return ResponseEntity.ok(basketService.getBasket(1L));
  }
}
