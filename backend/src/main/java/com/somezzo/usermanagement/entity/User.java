package com.somezzo.usermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Version  
    private Long version;

    @NotNull
	private String name;
    
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    
    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "active")
    private boolean active;
    
    
    //Constructor
    public User() { 	
    }
    
    public User(Long id, String name, String email, String password, Role role, boolean active) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
	}

	//Getters and Setters
    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
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

    public String getPassword() {
		return password;
	}

    public void setPassword(String password) {
		this.password = password;
	}

    public Role getRole() {
		return role;
	}

    public void setRole(Role role) {
		this.role = role;
	}

    public boolean getActive() {
		return active;
	}

    public void setActive(boolean active) {
		this.active = active;
	}


    //toString() methode
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", active=" + active + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getRole() + ", getActive()="
				+ getActive() + "]";
	}

	
	
	
}

