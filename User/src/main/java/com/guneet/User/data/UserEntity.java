package com.guneet.User.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false,length=50)
	private String firstName;

	@Column(nullable = false,length=50)
	private String lastName;	

	@Column(nullable = false,length=120,unique = true)
	private String email;

	@Column(nullable = false,unique = true)
	private String userId;

	@Column(nullable = false,unique = true)
	private String encryptedPassword;



	private static final long serialVersionUID = 3529898435600336475L;

	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getUserId() {
		return userId;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
}
