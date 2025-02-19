package com.devoir.copres.dtoRequest;

public record PersonnelRequest(
		
		String nom,
		String prenom,
		String telephone,
		String numeroCni,
		String 	adresse,
		String matricle
		
		) implements DtoGenericRequest {

}
