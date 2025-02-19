package com.devoir.copres.dtoResponse;


import java.util.UUID;

public record CategorieResponse(
		UUID trackingId,
		String libelle,
		String description
) implements DtoGenericResponse {}
