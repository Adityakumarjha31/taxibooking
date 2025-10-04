package tech.codehunt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name ="contactform")

public class ContactForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="Name Cannot be Empty")
	@Size(min = 2, max=30,message="Invalid Name Size")
	@Column(length = 30)
	
	private String name;
	@NotEmpty(message="Email Cannot be Empty")
	@Size(min = 5, max=100,message="Invalid Email Size")
	@Column(length = 50)
	private String email;
	
	@NotNull(message = "Phone number cannot be empty")
	@Min(value = 1000000000, message = "Phone number must be at least 10 digits")
	@Max(value = 9999999999L, message = "Phone number must be at most 10 digits")

	@Column(length = 10)
	private Long phone;
	@NotEmpty(message="Message  Cannot be Empty")
	@Size(min = 2, max=1000,message="Invalid Message Size")
	@Column(length = 1000)
	private String message;

}
