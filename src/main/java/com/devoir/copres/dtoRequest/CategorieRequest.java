package com.devoir.copres.dtoRequest;

public record CategorieRequest(
		
		String libelle,
		String description
		
		) implements DtoGenericRequest {

}
