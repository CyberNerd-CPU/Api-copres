package com.devoir.copres.dtoResponse;

import java.time.LocalDate;
import java.util.UUID;

public record EtatVenteResponse(
		
		UUID trackingId,
		Double montantTotal,
		Double nombreVente,
		LocalDate dateBebut,
		LocalDate dateFin,
		UUID commercialeId,
		UUID factureId
		
		) implements DtoGenericResponse {

}
