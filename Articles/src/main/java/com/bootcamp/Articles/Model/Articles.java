package com.bootcamp.Articles.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Articles {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private int stock, code;
	
	@NotNull
	private double price;
	
	@NotEmpty
	private String name;
	
	public Articles(int s, int c, double p, String n) {
		stock = s;
		code = c;
		price = p;
		name = n;
	}
}
