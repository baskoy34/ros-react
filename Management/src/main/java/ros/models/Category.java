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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String name;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Store store;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}
