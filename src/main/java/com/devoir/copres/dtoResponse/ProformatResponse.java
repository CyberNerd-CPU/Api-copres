package com.devoir.copres.dtoResponse;

import java.util.UUID;


public record ProformatResponse(
		
		UUID trackingId,
		Double montantTotal,
		String statut,
		UUID client
		
		) implements DtoGenericResponse
{

}
