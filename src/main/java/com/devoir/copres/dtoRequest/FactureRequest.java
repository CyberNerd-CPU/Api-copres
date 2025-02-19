package com.devoir.copres.dtoRequest;

import java.time.LocalDate;
import java.util.UUID;

public record FactureRequest(
		
		LocalDate echeance_date,
		Double montantTotal,
		Double montantPayer,
		UUID proformatId
		
		) implements DtoGenericRequest {

}
