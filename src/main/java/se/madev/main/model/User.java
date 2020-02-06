package se.madev.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="users")
public class User implements Serializable{

    @Id
<<<<<<< HEAD
    @GeneratedValue //generate a unique id starting from
=======
    @GeneratedValue
>>>>>>> 9c0f47169e5aa95ebbac67798841af680b6e2046
    @Column(name="id")
    private int id;
    
    @Column(name="firstname")
    private String firstName;
    
    @Column(name="lastname")
    private String lastName;
    
    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    
    @Column(name="dateofbirth")
    private Date dateOfBirth;
    
<<<<<<< HEAD
    @Min(0) //id = 0 -> applicant?
    @Max(1) //id = 1 -> recruiter?
    @Column(name="role")
    private int role;
=======
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
>>>>>>> 9c0f47169e5aa95ebbac67798841af680b6e2046

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
}