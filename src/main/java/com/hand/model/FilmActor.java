package com.hand.model;
// Generated 2015-8-28 8:59:03 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * FilmActor generated by hbm2java
 */
public class FilmActor implements java.io.Serializable {

	private FilmActorId id;
	private Actor actor;
	private Film film;
	private Date lastUpdate;

	public FilmActor() {
	}

	public FilmActor(FilmActorId id, Actor actor, Film film, Date lastUpdate) {
		this.id = id;
		this.actor = actor;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	public FilmActorId getId() {
		return this.id;
	}

	public void setId(FilmActorId id) {
		this.id = id;
	}

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
