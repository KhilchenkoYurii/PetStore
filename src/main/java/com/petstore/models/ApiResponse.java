package com.petstore.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
	private int code;
	private String type;
	private String message;
}
