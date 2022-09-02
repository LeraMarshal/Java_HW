import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main2 {
    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("123.45"); // 123.45 rub
        BigDecimal tax = new BigDecimal("0.19"); // 19%

        BigDecimal taxAmount = price.multiply(tax).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = price.add(taxAmount);

        System.out.println(taxAmount); // 23.46
        System.out.println(total);     // 146.91
    }
}
