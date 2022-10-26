package com.teste.cV.model;



import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo título é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;

	@ManyToMany
	@JsonIgnoreProperties("clientes")
	private List<Vendedores> vendedores;

	public Clientes(Long id, String nome, List<Vendedores> vendedores) {
		super();
		this.id = id;
		this.nome = nome;
		this.vendedores = vendedores;
	}

	public Clientes() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Vendedores> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedores> vendedores) {
		this.vendedores = vendedores;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
