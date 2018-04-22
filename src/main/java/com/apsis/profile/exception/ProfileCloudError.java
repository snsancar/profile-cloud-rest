package com.apsis.profile.exception;
/**
 * Be-spoke Exception class for Profile Cloud APplication.
 * @author sankar
 *
 */
public class ProfileCloudError {

	private String errorMessage;

	public ProfileCloudError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
