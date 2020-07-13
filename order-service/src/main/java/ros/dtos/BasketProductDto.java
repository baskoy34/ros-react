package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BasketProductDto {

	private long id;

	private Integer piece;

	private Long productId;

	private Long basketId;

	public BasketProductDto() {
	}

	public BasketProductDto(long id, Integer piece, Long productId, Long basketId) {
		this.id = id;
		this.piece = piece;
		this.productId = productId;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}
}
