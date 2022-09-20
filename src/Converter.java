public class Converter {
    static final double STEP_SIZE = 0.75;
    static final int CALORIES_PER_STEP = 50;

    public static void countDistance(StepTracker.MonthData month){
        int stepsSum = 0;
        for (int i = 0; i < month.monthDays.length; i++){
            stepsSum += month.monthDays[i];
        }
        double distance = stepsSum * STEP_SIZE;
        System.out.println("Пройденое расстояние за месяц: "
                + metersToKilometers(distance) + " км");
    }

    public static void countCalories(StepTracker.MonthData month){
        int caloriesSum = 0;
        int stepsSum = 0;
        for (int i = 0; i < month.monthDays.length; i++){
            stepsSum += month.monthDays[i];
        }
        caloriesSum = stepsSum * CALORIES_PER_STEP;
        System.out.println("Количество сожженых килокалорий за месяц: "
                + caloriesToKilocalories(caloriesSum));
    }

    private static double metersToKilometers(double meters){
        return meters/1000;
    }

    private static int caloriesToKilocalories(int calories){
        return calories/1000;
    }
}
