import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        PositionMonth n = new PositionMonth();
        ReportingMethods methods = new ReportingMethods();
        Scanner s = new Scanner(System.in);
        while (true){
            printMenu();
            int number = s.nextInt();
            switch (number){
                case 1:
                    methods.countAllMonthlyReport();
                    break;
                case 2:
                    methods.countAllYearlyReport();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Такой команды нет повторите ввод");
            }
        }

    }
    static void printMenu(){
        System.out.println("1. Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n" +
                "3 - Сверить отчёты\n" +
                "4 - Вывести информацию о всех месячных отчётах\n" +
                "5 - Вывести информацию о годовом отчёте\n" +
                "6 - Выход из программы \n" +
                "Введите номер команды.");
    }
}

