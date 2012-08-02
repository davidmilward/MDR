package uk.org.datalink.MDR.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private int resourceId;
	
	public ResourceNotFoundException(int resourceId) {
		this.resourceId = resourceId;
	}
	
	public int getResourceId() {
		return resourceId;
	}
	
}