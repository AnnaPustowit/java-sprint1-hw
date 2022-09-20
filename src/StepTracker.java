import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData;
    int stepsGoal;

    public StepTracker() {
        monthToData = new MonthData[12];
        stepsGoal = 10000;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] monthDays;
        public MonthData() {
            monthDays = new int[30];
        }
    }

    public void enterSteps(Scanner scanner){
        System.out.println("Введите номер месяца: ");
        int monthNumber = inputUserNumber(scanner, 1, 12) - 1;

        System.out.println("Введите номер дня: ");
        int dayNumber = inputUserNumber(scanner, 1, 30) - 1;

        System.out.println("Введите количество шагов: ");
        int stepsCount = inputUserNumber(scanner, 0, 100000);

        monthToData[monthNumber].monthDays[dayNumber] = stepsCount;
        System.out.println("Статистика сохранена");
    }

    public void showStatistic(Scanner scanner){
        System.out.println("Введите номер месяца: ");
        int monthNumber = inputUserNumber(scanner, 1, 12) - 1;

        showStatisticDaySteps(monthNumber);

        showStatisticMaxSteps(monthNumber);

        showStatisticAverageSteps(monthNumber);

        Converter.countDistance(monthToData[monthNumber]);

        Converter.countCalories(monthToData[monthNumber]);

        showStatisticBestSeries(monthNumber);
    }

    public void changeTarget(Scanner scanner){
        stepsGoal = inputUserNumber(scanner, 0, 100000);
        System.out.println("Установлена новая ежедневная цель количества шагов - " + stepsGoal);
    }

    private int inputUserNumber(Scanner scanner, int leftRange, int rightRange){
        System.out.println("Введите число от " + leftRange + " до " + rightRange);
        int number = scanner.nextInt();
        while(number < leftRange || number > rightRange){
            System.out.println("Некорректное число. Попробуйте снова: ");
            number = scanner.nextInt();
        }

        return number;
    }

    private void showStatisticDaySteps(int monthNumber){
        int lastDay = monthToData[monthNumber].monthDays.length;
        for(int i = 0; i < lastDay - 1; i++){
            System.out.print(i + 1 + " день: " + monthToData[monthNumber].monthDays[i] + ", ");

        }

        System.out.println(lastDay + " день: "
                + monthToData[monthNumber].monthDays[lastDay - 1]);
    }

    private void showStatisticMaxSteps(int monthNumber){
        int maxSteps = 0;
        for(int i = 0; i < monthToData[monthNumber].monthDays.length; i++) {
            if (maxSteps < monthToData[monthNumber].monthDays[i]) {
                maxSteps = monthToData[monthNumber].monthDays[i];
            }
        }
        System.out.println("Максимальное количество шагов за месяц: " + maxSteps);
    }

    private void showStatisticAverageSteps(int monthNumber){
        int averageSteps = 0;
        int daysCount = 0;
        for(int i = 0; i < monthToData[monthNumber].monthDays.length; i++) {
            averageSteps += monthToData[monthNumber].monthDays[i];
            ++daysCount;
        }
        System.out.println("Среднее количество шагов за месяц: " + averageSteps/daysCount);
    }

    private void showStatisticBestSeries(int monthNumber){
        int daysCount = 0;
        int maxSeries = 0 ;
        for(int i = 0; i < monthToData[monthNumber].monthDays.length; i++) {
            if(monthToData[monthNumber].monthDays[i] >= stepsGoal ){
                ++daysCount;
            }
            else{
                daysCount = 0;
            }
            if(maxSeries < daysCount){
                maxSeries = daysCount;
            }
        }
        System.out.println("Лучшая серия максимально подряд идущих дней: " + maxSeries);
    }
}


