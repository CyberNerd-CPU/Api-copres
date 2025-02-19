package com.devoir.copres.dtoRequest;

import java.time.LocalDate;
import java.util.UUID;

public record ReglementRequest(
		
		Double montantTotal,
		LocalDate dateReglement,
		UUID factureId,
		UUID modePayementId
		
		) implements DtoGenericRequest {

}
