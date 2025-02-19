package com.devoir.copres.dtoRequest;

public record ModePayementRequest(
		
		String libelle,
		String description
		
		) implements DtoGenericRequest {

}
