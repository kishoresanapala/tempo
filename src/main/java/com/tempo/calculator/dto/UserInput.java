package com.tempo.calculator.dto;

import java.math.BigDecimal;

public class UserInput {
	private BigDecimal firstNumber;
	private BigDecimal secondNumber;

	public UserInput(BigDecimal firstNumber, BigDecimal secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	/**
	 * @return the firstNumber
	 */
	public BigDecimal getFirstNumber() {
		return firstNumber;
	}

	/**
	 * @param firstNumber the firstNumber to set
	 */
	public void setFirstNumber(BigDecimal firstNumber) {
		this.firstNumber = firstNumber;
	}

	/**
	 * @return the secondNumber
	 */
	public BigDecimal getSecondNumber() {
		return secondNumber;
	}

	/**
	 * @param secondNumber the secondNumber to set
	 */
	public void setSecondNumber(BigDecimal secondNumber) {
		this.secondNumber = secondNumber;
	}
}
