package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record ModePayementResponse(
		
		UUID trackingId,
		String libelle,
		String description
		
		) implements DtoGenericResponse {

}
