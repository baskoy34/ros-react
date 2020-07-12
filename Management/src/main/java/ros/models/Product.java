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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String name;
	
	@Column(length = 500,nullable = false) 
	private String information;
	
	@Lob
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double vat;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<BasketProduct> basketProducts;
}
