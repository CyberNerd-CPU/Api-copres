package com.devoir.copres.dtoRequest;

import java.util.UUID;


public record ProformatRequest(
		
		UUID trackingId,
		Double montantTotal,
		String statut,
		UUID clientId
		
		) implements DtoGenericRequest {

}
