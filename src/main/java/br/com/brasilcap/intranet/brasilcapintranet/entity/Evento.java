package br.com.brasilcap.intranet.brasilcapintranet.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "EVENTO_TB")
public class Evento {
	private BigDecimal idEvento;
	private String descEvento;
	private Date dataEvento;
	private Date dataInclusao;
	private Date dataAlteracao;
	private String usuario;

	public Evento() {
	}

	public Evento(BigDecimal idEvento, Date dataInclusao, String usuario) {
		this.idEvento = idEvento;
		this.dataInclusao = dataInclusao;
		this.usuario = usuario;
	}

	public Evento(BigDecimal idEvento, String descEvento, Date dataEvento, Date dataInclusao, Date dataAlteracao,
			String usuario) {
		this.idEvento = idEvento;
		this.descEvento = descEvento;
		this.dataEvento = dataEvento;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuario = usuario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ALTERACAO", length = 7)
	public Date getDataAlteracao() {
		return this.dataAlteracao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EVENTO", length = 7)
	public Date getDataEvento() {
		return this.dataEvento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INCLUSAO", nullable = false, length = 7)
	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	@Column(name = "DESC_EVENTO", length = 150)
	public String getDescEvento() {
		return this.descEvento;
	}

	@Id

	@Column(name = "ID_EVENTO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdEvento() {
		return this.idEvento;
	}

	@Column(name = "USUARIO", nullable = false, length = 20)
	public String getUsuario() {
		return this.usuario;
	}

	public void setIdEvento(BigDecimal idEvento) {
		this.idEvento = idEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
