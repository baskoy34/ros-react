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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String username;
	
	@Column(length = 75,nullable = false) 
	private String password;
	
	@Column(length = 75,nullable = false) 
	private Boolean active;
	
	@OneToOne
	private Person person;

	@ManyToMany
	private List<Role> roles;
	
	@ManyToOne
	@JoinColumn
	private Store store;
	
}
