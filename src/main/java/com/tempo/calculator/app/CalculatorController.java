package com.tempo.calculator.app;

import static com.tempo.calculator.dto.ResultBuilder.getResponse;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tempo.calculator.dto.Response;
import com.tempo.calculator.dto.UserInput;

@RestController
@RequestMapping("/")
public class CalculatorController {

	@PostMapping(path = "/addNum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addNumber(@Valid @RequestBody UserInput input) {
		return getResponse(input.getFirstNumber().add(input.getSecondNumber()));
	}

	@PostMapping(path = "/subtractNum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response subtractNumber(@Valid @RequestBody UserInput input) {
		return getResponse(input.getFirstNumber().subtract(input.getSecondNumber()));
	}

	@PostMapping(path = "/multiplyNum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response multiplyNumber(@Valid @RequestBody UserInput input) {
		return  getResponse(input.getFirstNumber().multiply(input.getSecondNumber()));
	}

	@PostMapping(path = "/divideNum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response divideNumber(@Valid @RequestBody UserInput input) {
		return getResponse(input.getFirstNumber().divide(input.getSecondNumber()));
	}

}
