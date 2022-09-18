public class Converter {
    static double stepSize = 0.75;
    static int caloriesPerStep = 50;

    public static void countDistance(StepTracker.MonthData month){
        int stepsSum = 0;
        for (int i = 0; i < month.monthDays.length; ++i){
            stepsSum += month.monthDays[i];
        }
        double distance = stepsSum * stepSize;
        System.out.println("Пройденое расстояние за месяц: "
                + metersToKilometers(distance) + " км");
    }

    public static void countCalories(StepTracker.MonthData month){
        int caloriesSum = 0;
        int stepsSum = 0;
        for (int i = 0; i < month.monthDays.length; ++i){
            stepsSum += month.monthDays[i];
        }
        caloriesSum = stepsSum * caloriesPerStep;
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
