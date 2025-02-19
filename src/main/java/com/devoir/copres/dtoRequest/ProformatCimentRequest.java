package com.devoir.copres.dtoRequest;

import java.util.UUID;

public record ProformatCimentRequest(
		
		UUID cimentId,
		UUID proformatId
		
		) implements DtoGenericRequest {

}
