package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.services.BasketServiceImpl;

@RequestMapping("/basket")
@RestController
@RequiredArgsConstructor
public class BasketApi {
  private final   BasketServiceImpl basketService;

  public ResponseEntity<BasketDto>addToBasket(@RequestBody BasketProductDto basketProductDto){
      BasketDto basketDto =null;
      try {
           basketDto = basketService.addtoBasket(basketProductDto);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return ResponseEntity.ok(basketDto);
  }
}
