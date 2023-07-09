package br.com.brasilcap.intranet.brasilcapintranet.dto;

import br.com.brasilcap.intranet.brasilcapintranet.entity.Pessoa;

public class PessoaDTO {
	private String username;

	private String nome;

	private String pessoalMatricula;
	
	public PessoaDTO(Pessoa pessoa) {
		this.username = pessoa.getUsername();
		this.nome = pessoa.getNome();
		this.pessoalMatricula = pessoa.getPessoalMatricula();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPessoalMatricula() {
		return pessoalMatricula;
	}

	public void setPessoalMatricula(String pessoalMatricula) {
		this.pessoalMatricula = pessoalMatricula;
	}
	
	
}
