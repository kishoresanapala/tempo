package com.tempo.calculator.dto;

public class Response {

	private String result;
	private String error;

	private Response() {
	}

	public static Response withResult(String resultMessage) {
		Response response = new Response();
		response.result = resultMessage;
		return response;
	}

	static Response withError(String errorMessage) {
		Response response = new Response();
		response.error = errorMessage;
		return response;
	}

	public String getResult() {
		return result;
	}

	public String getError() {
		return error;
	}
}
