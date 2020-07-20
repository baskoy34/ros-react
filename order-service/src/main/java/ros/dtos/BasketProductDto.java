package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class BasketProductDto {

	private long id;

	private Integer piece;

	private ProductDto productDto;

	private Long basketId;

	public BasketProductDto() {
	}

	public BasketProductDto(long id, Integer piece, ProductDto productDto, Long basketId) {
		this.id = id;
		this.piece = piece;
		this.productDto = productDto;
		this.basketId = basketId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPiece() {
		return piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}
}
