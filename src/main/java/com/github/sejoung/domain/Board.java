package com.github.sejoung.domain;

import com.github.sejoung.constants.CommonConstants;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "TB_BOARD")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String title;

	@Column(length = 1000, nullable = false)
	private String contents;	
		
	@Column(nullable = false)
	private int hit;
	
	@Column(nullable = false)
	private LocalDateTime createDate;

	@Column(nullable = false)
	private String createUser;
	
	private LocalDateTime updateDate;

	private String updateUser;
	
	@PrePersist
	public void prePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.setCreateDate(now);
		this.setCreateUser(CommonConstants.TEST_USER);
		this.setUpdateDate(now);
		this.setUpdateUser(CommonConstants.TEST_USER);
		this.setHit(0);
	}

	@PreUpdate
	public void preUpdate() {
		this.setUpdateDate(LocalDateTime.now());
		this.setUpdateUser(CommonConstants.TEST_USER);

	}

}
