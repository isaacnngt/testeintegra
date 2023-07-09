package br.com.brasilcap.intranet.brasilcapintranet.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INT_PARAMETRO_PROCESSO_TB", schema = "INTRANET")
public class Parametro {

	private long idParametro;
	// @Ordenador
	private String nomeParametro;
	private String descFuncaoParametro;
	private String descConteudoParametro;

	public Parametro() {
	}

	public Parametro(long idParametro) {
		this.idParametro = idParametro;
	}

	public Parametro(long idParametro, String nomeParametro, String descFuncaoParametro, String descConteudoParametro) {
		this.idParametro = idParametro;
		this.nomeParametro = nomeParametro;
		this.descFuncaoParametro = descFuncaoParametro;
		this.descConteudoParametro = descConteudoParametro;

	}

	@Column(name = "DESC_CONTEUDO_PARAMETRO", length = 2000)
	public String getDescConteudoParametro() {
		return this.descConteudoParametro;
	}

	@Column(name = "DESC_FUNCAO_PARAMETRO")
	public String getDescFuncaoParametro() {
		return this.descFuncaoParametro;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID_PARAMETRO", unique = true, nullable = false, precision = 10, scale = 0)
	public long getIdParametro() {
		return this.idParametro;
	}

	@Column(name = "NOME_PARAMETRO")
	public String getNomeParametro() {
		return this.nomeParametro;
	}

	public void setDescConteudoParametro(String descConteudoParametro) {
		this.descConteudoParametro = descConteudoParametro;
	}

	public void setDescFuncaoParametro(String descFuncaoParametro) {
		this.descFuncaoParametro = descFuncaoParametro;
	}

	public void setIdParametro(long idParametro) {
		this.idParametro = idParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	
}
