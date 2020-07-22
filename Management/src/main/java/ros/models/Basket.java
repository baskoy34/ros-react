package ros.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false) 
	private double totalPrice;
	
	@Column(nullable = false) 
	private double totalVat;
	
	@OneToMany(mappedBy = "basket")
	private List<BasketProduct> basketProducts;
	
}
