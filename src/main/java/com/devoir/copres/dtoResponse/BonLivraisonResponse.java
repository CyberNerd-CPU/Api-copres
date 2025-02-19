package com.devoir.copres.dtoResponse;

import java.time.LocalDate;
import java.util.UUID;

public record BonLivraisonResponse(
		UUID trackingId,
		String nmeroBon,
		LocalDate dateLivraison,
		String adresseLivraison,
		String statut
		) implements DtoGenericResponse {}
