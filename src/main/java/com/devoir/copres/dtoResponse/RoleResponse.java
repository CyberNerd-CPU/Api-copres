package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record RoleResponse(
		
		UUID trackingId,
		String libelle,
		String description
		
		) implements DtoGenericResponse {}
