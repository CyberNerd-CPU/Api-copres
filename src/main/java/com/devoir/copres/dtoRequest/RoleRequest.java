package com.devoir.copres.dtoRequest;

public record RoleRequest(
		
		String libelle,
		String code
		
		) implements DtoGenericRequest {

}
