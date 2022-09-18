import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StepTracker my_tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if(userInput == 1){         // Ввести количество шагов за определённый день
                my_tracker.enterSteps(scanner);
            }
            else if(userInput == 2){    // Напечатать статистику за определённый месяц
                my_tracker.showStatistic(scanner);
            }
            else if(userInput == 3){    // Изменить цель по количеству шагов в день
                my_tracker.changeTarget(scanner);
            }
            else {
                System.out.println("Такой команды нет");
            }
            System.out.println();
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
    }
}