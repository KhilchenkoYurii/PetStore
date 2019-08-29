package com.petstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties
public class Pet {
	@JsonProperty("id")
	private int id;
	@JsonProperty("category")
	private Category category;
	@JsonProperty("name")
	private String name;
	@JsonProperty("photoUrls")
	private List<String> photoUrls;
	@JsonProperty("tags")
	private List<Tag> tags;
	@JsonProperty("status")
	private String status = "available";

}
