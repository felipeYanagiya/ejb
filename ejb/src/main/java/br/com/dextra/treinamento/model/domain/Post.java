package br.com.dextra.treinamento.model.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String titulo;

    private String descricao;

    private Date data = new Date();

    public Post() {

    }

    public Post(String titulo, String descricao) {
	this.titulo = titulo;
	this.descricao = descricao;
    }

    @Column
    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    @Column
    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    @Column
    @Temporal(TemporalType.DATE)
    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String formatDate(Date data) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	return data == null ? "NA" : sdf.format(data);
    }

    @Override
    public String toString() {
	return "Post [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", data=" + formatDate(data) + "]";
    }

}
