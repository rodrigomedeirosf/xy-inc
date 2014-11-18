package br.com.xy.poi.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="tb_poi")
public class Poi implements Serializable {
	
	private static final long serialVersionUID = 6564762478492211072L;
	
	public Poi() {

	}
	
	public Poi(String name, Integer x, Integer y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public Poi(Integer id, String name, Integer x, Integer y) {
		this(name, x, y);
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@NotNull
	@Column
	private String name;
	
	@Min(1)
	@Column
	private Integer x;
	
	@Min(1)
	@Column
	private Integer y;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}
