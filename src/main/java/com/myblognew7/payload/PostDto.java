package com.myblognew7.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import com.sun.istack.NotNull;

public class PostDto {
	
private long id;
	
	@NotNull
	@Size(min=2, message = "atleast 3 character")
	private String title;
	

	@Max(value = 20)
	private String description;
	
	@NotNull
	@NotEmpty
	@Size(min = 5)
	@Email
	private String content;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}