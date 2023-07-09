package br.com.brasilcap.intranet.brasilcapintranet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPS_CARGO_TB", schema = "INTRANET")
public class Cargo {
	private long cargoId;
	private String psCargoId;
	private String nomeRed;
	private String nome;
	private char status;
	
	@Id

	@Column(name = "CARGO_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getCargoId() {
		return this.cargoId;
	}

	@Column(name = "NOME", nullable = false, length = 50)
	public String getNome() {
		return this.nome;
	}

	@Column(name = "NOME_RED", nullable = false, length = 10)
	public String getNomeRed() {
		return this.nomeRed;
	}

	@Column(name = "PS_CARGO_ID", nullable = false, length = 8, columnDefinition = "char")
	public String getPsCargoId() {
		return this.psCargoId;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setCargoId(long cargoId) {
		this.cargoId = cargoId;
	}

	public void setPsCargoId(String psCargoId) {
		this.psCargoId = psCargoId;
	}

	public void setNomeRed(String nomeRed) {
		this.nomeRed = nomeRed;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
