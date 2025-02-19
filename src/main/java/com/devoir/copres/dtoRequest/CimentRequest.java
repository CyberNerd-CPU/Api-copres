package com.devoir.copres.dtoRequest;

import java.util.UUID;

public record CimentRequest(
		
		String libelle,
		Double prixUnitaire,
		int quantite,
		UUID categorieId
		
		) implements DtoGenericRequest {

}
