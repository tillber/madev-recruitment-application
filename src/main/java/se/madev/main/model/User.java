package se.madev.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Class "User" describes a user and their properties in our application
 */
@Entity
@Table(name="users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="firstname")
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[A-Za-z-]*$",message = "Invalid first name!")
    private String firstName;
    
    @Column(name="lastname")
    @NotBlank(message = "Last name is mandatory")
    @Pattern(regexp = "^[A-Za-z-]*$", message = "Invalid last name!")
    private String lastName;
    
    @Column(name="email", unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name="username", unique = true)
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(name="password")
    @NotBlank(message = "Password is mandatory")
    private String password;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Invalid date of birth!")
    @Column(name="dateofbirth")
    private Date dateOfBirth;
    
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
    
    public User(MyUserDetails user) {
    	this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.role = user.getRole();
    }
    
    public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", role="
				+ role + "]";
	}
}