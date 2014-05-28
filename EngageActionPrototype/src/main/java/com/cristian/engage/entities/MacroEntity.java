package com.cristian.engage.entities;

// Generated May 23, 2014 7:42:18 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Macro generated by hbm2java
 */
@Entity
@Table(name = "macro")
public class MacroEntity implements java.io.Serializable {

    static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<ActionEntity> actions = new ArrayList<ActionEntity>(0);

	public MacroEntity() {
	}

	public MacroEntity(String name, List<ActionEntity> actions) {
		this.name = name;
		this.actions = actions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "macro_has_action", joinColumns = { @JoinColumn(name = "macro_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "action_id", nullable = false, updatable = false) })
	public List<ActionEntity> getActions() {
		return this.actions;
	}

	public void setActions(List<ActionEntity> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "MacroEntity [id=" + id + ", name=" + name + ", actions=" + actions + "]";
	}

}