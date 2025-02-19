package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record CimentResponse(
		UUID trackingId,
		String libelle,
		Double prixUnitaire,
		int quantite,
		UUID categorieId,
		String categorieName
		) implements DtoGenericResponse {

}
