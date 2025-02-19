package com.devoir.copres.dtoResponse;

import java.time.LocalDate;
import java.util.UUID;


public record FactureResponse(
		
		UUID trackingId,
		LocalDate echeance_date,
		Double montantTotal,
		Double montantPayer,
		UUID proformatId
		
		) implements DtoGenericResponse {

}
