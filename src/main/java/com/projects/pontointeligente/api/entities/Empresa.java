package com.projects.pontointeligente.api.entities;

import java.util.Date;
import java.util.List;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 3960436649365666213L;
	
	private Long id;
	private String razaoSocial;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private List<Funcionario> funcionarios;
	
	public Empresa(){
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long pId) {
		this.id = pId;
	}
	
	@Column(name = "razao_social",nullable = false)
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String pRazaoSocial) {
		this.razaoSocial = pRazaoSocial;
	}
	
	@Column(name = "cnpj",nullable = false)
	public String getCpnj() {
		return cnpj;
	}
	
	public void setCnpj(String pCpnj) {
		this.cnpj = pCpnj;
	}
	
	@Column(name = "data_criacao",nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date pDataCriacao) {
		this.dataCriacao = pDataCriacao;
	}
	
	@Column(name = "data_atualizacao",nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date pDataAtualizacao) {
		this.dataAtualizacao = pDataAtualizacao;
	}
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	public void setFuncionarios(List <Funcionario> pFuncionarios) {
		this.funcionarios = pFuncionarios;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" +
		razaoSocial + ", cnpj=" + cnpj + 
		", dataCriacao=" + dataCriacao + ",	dataAtualizacao=" + dataAtualizacao + "]";
	}

	
}
