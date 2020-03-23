package com.openclassrooms.testing.calcul.service;

import com.openclassrooms.testing.calcul.domain.Calculator;
import com.openclassrooms.testing.calcul.domain.model.CalculationModel;
import com.openclassrooms.testing.calcul.domain.model.CalculationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    Calculator calculator = new Calculator();

    @Mock
    SolutionFormatter solutionFormatter;

    CalculatorService classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new CalculatorServiceImpl(calculator, solutionFormatter);
    }

    @Test
    public void calculate_shouldUseCalculator_forAddition() {
        when(calculator.add(1, 2)).thenReturn(3);
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();
        verify(calculator).add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_shouldUseCalculator_forAnyAddition() {
        final Random random = new Random();
        when(calculator.add(any(Integer.class), any(Integer.class))).thenReturn(3);
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION, random.nextInt(), random.nextInt())).getSolution();
        verify(calculator, times(1)).add(any(Integer.class), any(Integer.class));
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_shouldUseCalculator_forSubstract() {
        when(calculator.sub(2, 1)).thenReturn(1);
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.SUBTRACTION, 2, 1)).getSolution();
        verify(calculator).sub(2, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculate_shouldUseCalculator_forMultiplication() {
        when(calculator.multiply(2, 3)).thenReturn(6);
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.MULTIPLICATION, 2, 3)).getSolution();
        verify(calculator).multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calculate_shouldUseCalculator_forDivision() {
        when(calculator.divide(2, 2)).thenReturn(1);
        final int result = classUnderTest.calculate(new CalculationModel(CalculationType.DIVISION, 2, 2)).getSolution();
        verify(calculator).divide(2, 2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculate_shouldThrowIllegalArgument_forDivision0() {
        when(calculator.divide(1, 0)).thenThrow(new ArithmeticException());
        assertThrows(IllegalArgumentException.class,
                () -> classUnderTest.calculate(new CalculationModel(CalculationType.DIVISION, 1, 0)));
        verify(calculator, times(1)).divide(1, 0);
    }

    @Test
    public void calculate_shouldFormatSolution_forAddition() {
        when(calculator.add(10000, 3000)).thenReturn(13000);
        when(solutionFormatter.format(13000)).thenReturn("13 000");
        final String formattedResult = classUnderTest.calculate(new CalculationModel(CalculationType.ADDITION, 10000,
                3000)).getFormattedSolution();
        assertThat(formattedResult).isEqualTo("13 000");
    }
}
