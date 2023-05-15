package practice;

public class CalculatePowerValue {

    public static void main(String[] args) {
        Double value = 5.0;
        int power = -4;
        System.out.println("rezult = " + calculatePowerValue(value, power));
    }

    public static Double calculatePowerValue(Double value, int power) {
        Double answer = 1.0;
        int x = Math.abs(power);
        for(int i = 0; i < x; i++) {
            answer *= value;
        }
        return answer;
    }

}
