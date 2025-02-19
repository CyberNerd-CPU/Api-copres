package com.devoir.copres.dtoRequest;

import java.time.LocalDate;
import java.util.UUID;

public record EtatVenteRequest(
		
		Double montantTotal,
		Double nombreVente,
		LocalDate dateBebut,
		LocalDate dateFin,
		UUID commercialeId,
		UUID factureId
		
		) implements DtoGenericRequest {

}
