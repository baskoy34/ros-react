package ros.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false) 
	private Integer piece;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Basket basket;
	
}
