package com.devoir.copres.dtoRequest;

import java.time.LocalDate;

public record BonLivraisonRequest(
		
		String numeroBon,
		LocalDate dateLivraison,
		String adresseLivraison,
		String statut
		
		) implements DtoGenericRequest {

}
