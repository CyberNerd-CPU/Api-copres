package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record ClientResponse(
		UUID trackingId,
		String nom,
		String prenom,
		String telephone,
		String numeroCni,
		String adresse
		) implements DtoGenericResponse {

}
