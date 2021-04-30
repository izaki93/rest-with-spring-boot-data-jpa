package com.springboot.rest.restwithspringbootdatajpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public abstract class TrackedEntity extends IdEntity {

	@Column(name = "created", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdAt;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.modifiedAt = this.createdAt;
	}

	@PreUpdate
	protected void onPersist() {
		modifiedAt = new Date();
	}
}
