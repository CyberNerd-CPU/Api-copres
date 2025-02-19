package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record CommercialeResponse(
		UUID trackingId,
		String nom,
		String prenom,
		String telephone,
		String numeroCni,
		String 	adresse,
		String matricle
		) implements DtoGenericResponse {
	
	

}
