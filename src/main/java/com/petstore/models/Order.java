package com.petstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
	@JsonProperty("id")
	private int id;
	@JsonProperty("petId")
	private int petId;
	@JsonProperty("quantity")
	private int quantity;
	@JsonProperty("shipDate")
	private String shipDate;
	@JsonProperty("status")
	private OrderStatus status;
	@JsonProperty("complete")
	private boolean complete = false;
}
