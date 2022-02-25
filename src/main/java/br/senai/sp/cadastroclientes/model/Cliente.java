package br.senai.sp.cadastroclientes.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {

	private Long id;
	private String nome, endereco, telefone, email, prodInteresse, genero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataNasc;
	private Calendar dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProdInteresse() {
		return prodInteresse;
	}

	public void setProdInteresse(String prodInteresse) {
		this.prodInteresse = prodInteresse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public int getIdade() {
		int dia = dataNasc.get(Calendar.DAY_OF_MONTH);
		int mes = dataNasc.get(Calendar.MONTH);
		int ano = dataNasc.get(Calendar.YEAR);
		LocalDate dataNascimento = LocalDate.of(ano, mes+1, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNascimento, dataAtual);
		return periodo.getYears();
	}

}
