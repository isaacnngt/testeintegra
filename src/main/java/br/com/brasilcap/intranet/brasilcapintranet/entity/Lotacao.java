package br.com.brasilcap.intranet.brasilcapintranet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPS_LOTACAO_TB",schema = "INTRANET" )
public class Lotacao {
	private long lotacaoId;
	private Long pessoalId;
	private String codLotacao;

	private String diretoria;
	private String gerencia;
	private String codLotacaoPai;
	private String pessoalMatricula;
	private char status;
	private String areaPai;
	private String nivel;

	@Column(name = "AREA_PAI", length = 10, columnDefinition = "char")
	public String getAreaPai() {
		return this.areaPai;
	}

	@Column(name = "COD_LOTACAO", nullable = false, length = 10, columnDefinition = "char")
	public String getCodLotacao() {
		return this.codLotacao;
	}

	@Column(name = "COD_LOTACAO_PAI", length = 10, columnDefinition = "char")
	public String getCodLotacaoPai() {
		return this.codLotacaoPai;
	}

	@Column(name = "DIRETORIA", nullable = false, length = 35)
	public String getDiretoria() {
		return this.diretoria;
	}

	@Column(name = "GERENCIA", nullable = false, length = 35)
	public String getGerencia() {
		return this.gerencia;
	}

	@Id

	@Column(name = "LOTACAO_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getLotacaoId() {
		return this.lotacaoId;
	}

	@Column(name = "NIVEL", length = 2, columnDefinition = "char")
	public String getNivel() {
		return this.nivel;
	}

    @JsonIgnore
	@Column(name = "PESSOAL_ID", precision = 10, scale = 0)
	public Long getPessoalId() {
		return this.pessoalId;
	}

	@Column(name = "PESSOAL_MATRICULA", length = 11, columnDefinition = "char")
	public String getPessoalMatricula() {
		return this.pessoalMatricula;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setLotacaoId(long lotacaoId) {
		this.lotacaoId = lotacaoId;
	}

	public void setPessoalId(Long pessoalId) {
		this.pessoalId = pessoalId;
	}

	public void setCodLotacao(String codLotacao) {
		this.codLotacao = codLotacao;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	public void setCodLotacaoPai(String codLotacaoPai) {
		this.codLotacaoPai = codLotacaoPai;
	}

	public void setPessoalMatricula(String pessoalMatricula) {
		this.pessoalMatricula = pessoalMatricula;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setAreaPai(String areaPai) {
		this.areaPai = areaPai;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
