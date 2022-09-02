public class Main {
    public static void main(String[] args) {
        /*
        First level: Реализуйте программу, которая считает стоимость покупки, учитывая НДС.
        Т.е. дана стоимость товара и размер НДС (например, 19%) Ваша программа должна рассчитать,
        сколько, сколько вы должны оплатить, учитывая налог.

        Second level: none
         */

        // Финансовые (банковские) системы считают деньги в минимальных элементах валюты.
        long priceCopecks = 12345L; // 123.45 rub
        int taxPercent = 19; // 19%

        long taxCopecks = calculateTaxCopecks(priceCopecks, taxPercent);
        long totalCopecks = priceCopecks + taxCopecks;

        System.out.println("Price = " + copecksToRoubles(priceCopecks) + " rub");                   // Price = 123.45 rub
        System.out.println("Tax " + taxPercent + "% = " + copecksToRoubles(taxCopecks) + " rub");   // Tax 19% = 23.46 rub
        System.out.println("Total = " + copecksToRoubles(totalCopecks) + " rub");                   // Total = 146.91 rub
    }

    // https://www.b-kontur.ru/enquiry/688-okruglenie-nds .
    // Округление до копеек.
    public static long calculateTaxCopecks(long priceCopecks, int taxPercent) {
        long taxPrice = taxPercent * priceCopecks;
        long taxCopecks = taxPrice / 100;
        long remainder = taxPrice % 100;

        if (remainder >= 50L) {
            return taxCopecks + 1L;
        } else if (remainder <= -50L) {
            return taxCopecks - 1L;
        } else {
            return taxCopecks;
        }
    }

    public static double copecksToRoubles(long copecks) {
        return copecks/100.0;
    }
}