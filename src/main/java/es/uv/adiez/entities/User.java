package es.uv.adiez.entities;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

	@Id @Column
	private String nif;
	@Column
	private String name;
	@Column
	private String email;
	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType;
	@Column
	private String password;
	@Column(name="person_type")
	@Enumerated(EnumType.STRING)
	private PersonType personType;
	@Column
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column
    private int quantity;
	
	public User() {}
	
	public User(String nif, String name, String email, UserType userType, String password, PersonType personType, Status status, int quantity) {
		this.nif = nif;
		this.name = name;
		this.email = email;
		this.userType = userType;
		this.password = password;
		this.personType = personType;
		this.status = status;
		this.quantity = quantity;
	}
	
	public User(String nif, String name, String email, String password, PersonType personType, Status status, int quantity) {
		this.nif = nif;
		this.name = name;
		this.email = email;
		this.password = password;
		this.personType = personType;
		this.status = status;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PersonType getPersonType() {
		return personType;
	}
	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public enum UserType {
		P,
		V
	}
	public enum PersonType {
		F,
		J
	}
	public enum Status {
		P,
		A,
		I
	}
}
