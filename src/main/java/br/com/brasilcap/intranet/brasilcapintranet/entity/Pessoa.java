package br.com.brasilcap.intranet.brasilcapintranet.entity;

import java.util.Date;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "IPS_PESSOAL_TB", schema = "INTRANET")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pessoa {

	private long pessoalId;
	private String pessoalMatricula;
	private boolean isConsultor;
	private String nome;
	private String empresaId;
	private Long intLotacaoId;
	private String username;
	private String ramal;
	private Character situacao;
	private Long localizacaoId;
	private char status;
	private String empresaNome;
	private Date dtNasc;
	private String empresaIdNovo;
	private String ddd;
	private String telefone;

	private Cargo cargo;
	private Lotacao lotacao;


	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CARGO_ID")
	public Cargo getCargo() {
		return cargo;
	}

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOTACAO_ID")
	public Lotacao getLotacao() {
		return lotacao;
	}

	public String toString() {
		return "Pessoa [dtNasc=" + dtNasc + ", empresaId=" + empresaId + ", empresaIdNovo=" + empresaIdNovo
				+ ", empresaNome=" + empresaNome + ", temFoto=" + temFoto + ", localizacaoId=" + localizacaoId
				+ ", lotacao=" + lotacao + ", nome=" + nome +  ", pessoalMatricula="
				+ pessoalMatricula + ", ramal=" + ramal + ", situacao=" + situacao + ", status=" + status
				+ ", username=" + username + ", isConsultor=" + isConsultor + "]";
	}

	@JsonIgnore
	@Column(name = "DDD", length = 4, columnDefinition = "char", updatable = false, insertable = false)
	public String getDdd() {
		return this.ddd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_NASC", length = 7, updatable = false, insertable = false)
	public Date getDtNasc() {
		return this.dtNasc;
	}

	@Column(name = "EMPRESA_ID", nullable = false, length = 5, columnDefinition = "char", updatable = false, insertable = false)
	public String getEmpresaId() {
		return this.empresaId;
	}

	@Column(name = "EMPRESA_ID_NOVO", length = 5, columnDefinition = "char", updatable = false, insertable = false)
	public String getEmpresaIdNovo() {
		return this.empresaIdNovo;
	}

	@Column(name = "EMPRESA_NOME", length = 60, updatable = false, insertable = false)
	public String getEmpresaNome() {
		return this.empresaNome;
	}

	@JsonIgnore
	@Column(name = "INT_LOTACAO_ID", precision = 10, scale = 0, updatable = false, insertable = false)
	public Long getIntLotacaoId() {
		return this.intLotacaoId;
	}

	@JsonIgnore
	private transient byte[] foto;

	@Transient
	private transient boolean temFoto;

	@Transient
	public Boolean getTemFoto() {
		return temFoto;
	}

	@Column(name = "LOCALIZACAO_ID", precision = 10, scale = 0, updatable = false, insertable = false)
	public Long getLocalizacaoId() {
		return this.localizacaoId;
	}

	@Column(name = "NOME", nullable = false, length = 100, updatable = false, insertable = false)
	public String getNome() {
		return this.nome;
	}

	@JsonIgnore
	@PostLoad
	private void onLoad() {
		this.temFoto = (foto != null);
	}

	@JsonIgnore
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Lob
	@JsonIgnore
	@Column(name = "FOTO", updatable = false, insertable = false)
	public byte[] getFoto() {
		return null;
	}

	public byte[] fotoA() {
		return foto;
	}

	@Id

	@Column(name = "PESSOAL_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getPessoalId() {
		return this.pessoalId;
	}

	@Column(name = "PESSOAL_MATRICULA", nullable = false, length = 11, columnDefinition = "char")
	public String getPessoalMatricula() {
		return this.pessoalMatricula;
	}

	@Column(name = "RAMAL", length = 4, columnDefinition = "char")
	public String getRamal() {
		return this.ramal;
	}

	@Column(name = "SITUACAO", length = 1)
	public Character getSituacao() {
		return this.situacao;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	@Column(name = "TELEFONE", length = 10, columnDefinition = "char")
	public String getTelefone() {
		return this.telefone;
	}

	@Column(name = "USERNAME", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	@Column(name = "IS_CONSULTOR", nullable = false, precision = 1, scale = 0)
	public boolean isIsConsultor() {
		return this.isConsultor;
	}

	public void setPessoalId(long pessoalId) {
		this.pessoalId = pessoalId;
	}

	public void setPessoalMatricula(String pessoalMatricula) {
		this.pessoalMatricula = pessoalMatricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmpresaId(String empresaId) {
		this.empresaId = empresaId;
	}

	public void setIntLotacaoId(Long intLotacaoId) {
		this.intLotacaoId = intLotacaoId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public void setLocalizacaoId(Long localizacaoId) {
		this.localizacaoId = localizacaoId;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setEmpresaNome(String empresaNome) {
		this.empresaNome = empresaNome;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public void setEmpresaIdNovo(String empresaIdNovo) {
		this.empresaIdNovo = empresaIdNovo;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	public void setIsConsultor(boolean isConsultor) {
		this.isConsultor = isConsultor;
	}

}
