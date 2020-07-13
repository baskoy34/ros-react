package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private long id;

	private String name;

	private String information;

	private double price;

	private double vat;

	private String category;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInformation() {
		return information;
	}

	public double getPrice() {
		return price;
	}

	public double getVat() {
		return vat;
	}

	public String getCategory() {
		return category;
	}

}
