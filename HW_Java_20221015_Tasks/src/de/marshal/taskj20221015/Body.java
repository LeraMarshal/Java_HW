package de.marshal.taskj20221015;

public class Body {
    private enum BMI {UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESE}

    private BMI bmi;

    public Body(int weight, double height) {
        double bmiValue = weight / Math.pow(height, 2);

        if (bmiValue < 18.5) {
            bmi = BMI.UNDERWEIGHT;
        } else if (bmiValue < 25) {
            bmi = BMI.NORMAL;
        } else if (bmiValue < 30) {
            bmi = BMI.OVERWEIGHT;
        } else {
            bmi = BMI.OBESE;
        }
    }

    public void printBMI() {
        System.out.println(bmi);
    }
}
