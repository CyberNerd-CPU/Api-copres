package com.devoir.copres.dtoRequest;

public record CommercialeRequest(
		
		
		String nom,
		String prenom,
		String telephone,
		String numeroCni,
		String 	adresse,
		String matricle
		
		) implements DtoGenericRequest {

}
