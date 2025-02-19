package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record PersonnelResponse(
		
		UUID trackingId,
		String nom,
		String prenom,
		String telephone,
		String numeroCni,
		String 	adresse,
		String matricle
		
		) implements DtoGenericResponse {

}
