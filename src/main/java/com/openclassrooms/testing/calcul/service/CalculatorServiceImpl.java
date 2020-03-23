package com.openclassrooms.testing.calcul.service;

import com.openclassrooms.testing.calcul.domain.Calculator;
import com.openclassrooms.testing.calcul.domain.model.CalculationModel;
import com.openclassrooms.testing.calcul.domain.model.CalculationType;

public class CalculatorServiceImpl implements CalculatorService {

	private final Calculator calculator;

	public CalculatorServiceImpl(Calculator calculator, SolutionFormatter solutionFormatter) {
		this.calculator = calculator;
		this.solutionFormatter = solutionFormatter;
	}

	private SolutionFormatter solutionFormatter;

	@Override
	public CalculationModel calculate(CalculationModel calculationModel) {
		final CalculationType type = calculationModel.getType();

		Integer response = null;
		switch (type) {
		case ADDITION:
			response = calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
			break;
		case SUBTRACTION:
			response = calculator.sub(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
			break;
		case MULTIPLICATION:
			response = calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
			break;
		case DIVISION:
			try {
				response = calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
			} catch (final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
			break;
		default:
			throw new UnsupportedOperationException("Unsupported calculations");
		}

		calculationModel.setSolution(response);
		calculationModel.setFormattedSolution(solutionFormatter.format(response));
		return calculationModel;
	}

}
