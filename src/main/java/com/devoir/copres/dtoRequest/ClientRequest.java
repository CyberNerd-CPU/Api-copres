package com.devoir.copres.dtoRequest;

public record ClientRequest(
		
		String nom,
		String prenom,
		String telephone,
		String numeroCni,
		String adresse
		
		) implements DtoGenericRequest {}
