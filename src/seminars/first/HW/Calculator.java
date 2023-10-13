package seminars.first.HW;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(calculatingDiscount(10,10));
        //Проверка корректного расчета
        assertThat(calculatingDiscount(10,10)).isEqualTo(9);
        //Проверка выброса исключения при отрицательной скидке
        assertThatThrownBy(() -> calculatingDiscount(10.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");
        //Проверка выброса исключения при отрицательной сумме покупки
        assertThatThrownBy(() -> calculatingDiscount(-10.0, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");
        //Проверка выброса исключения при скидке больше 100%
        assertThatThrownBy(() -> calculatingDiscount(10.0, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");
    };
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
            if(num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {

        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount > 100) {
            throw new ArithmeticException("Invalid arguments");
        }
        return purchaseAmount - purchaseAmount * discountAmount / 100;

    }
}