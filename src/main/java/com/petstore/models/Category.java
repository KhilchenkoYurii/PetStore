package com.petstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
}
