package com.devoir.copres.dtoResponse;

import java.time.LocalDate;
import java.util.UUID;


public record ReglementResponse(
		
		UUID trackingId,
		Double montantTotal,
		LocalDate dateReglement,
		UUID factureId,
		UUID modePayementId
		
		) implements DtoGenericResponse {

}
