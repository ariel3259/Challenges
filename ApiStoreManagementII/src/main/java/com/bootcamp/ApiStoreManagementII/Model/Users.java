package com.bootcamp.ApiStoreManagementII.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"email"})
		}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	private String lastName;
	private String name;
	private String password;

	public Users(String email, String lastName, String password, String name) {
		this.email = email;
		this.lastName = lastName;
		this.password = password;
		this.name = name;
	}
}