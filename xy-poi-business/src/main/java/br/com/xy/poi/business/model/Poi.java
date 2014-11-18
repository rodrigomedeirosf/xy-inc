package br.com.xy.poi.business.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Poi implements Serializable {

	private static final long serialVersionUID = -8458525765344262650L;
	
	public Poi() {
		super();
	}
	
	public Poi(String name, Integer x, Integer y) {
		this();
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public Poi(Integer id, String name, Integer x, Integer y) {
		this(name, x, y);
		this.id = id;
	}

	private Integer id;
	private String name;
	private Integer x;
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
