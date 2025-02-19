package com.devoir.copres.dtoResponse;

import java.util.UUID;

public record ProformatCimentResponse(
		
		UUID trackingId,
		UUID cimentId,
		
		UUID proformatId
		
		) implements DtoGenericResponse {

}
