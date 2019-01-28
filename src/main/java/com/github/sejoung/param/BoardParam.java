package com.github.sejoung.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
public class BoardParam {

	private Long boardId;
	
	@NotNull
	private String boardTitle;
	
	@NotNull
	@Size(min = 1, max = 1000)
	private String boardContents;

}
