package com.restaurant.entity;


import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

	    @Id

	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

//	    @NotNull
	    @Column(name="full_name")
	    private String fullName;

//	    @NotNull
	    @Column(name="email")
	    private String email;

//	    @NotNull
	    @Column(name="password")
	    private String password;


	@ManyToOne
	@JoinColumn(name="role_id")
		private RoleType role;

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
}
