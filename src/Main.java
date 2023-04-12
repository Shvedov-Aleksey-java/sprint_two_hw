import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);
        ReportEngine methods = new ReportEngine();
        /*
        когда я передаю обьект сканер в констркетор а не пишу как сейчас он мне кидает исключенние:
        Введите номер команды.
1
введите путь к файлу: 1
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 1
	at ReportEngine.addMonthlyReport(ReportEngine.java:34)
	at ReportEngine.countAllMonthlyReport(ReportEngine.java:91)
	at Main.main(Main.java:15)

Process finished with exit code 1

когда запускаю отладку если передать сканер то он передает вместе сэтим обьектом то чиссло которое я ввел и не реализуетс в другом классе.
         */
        while (true){
            printMenu();
            int number = scanner.nextInt();
            switch (number){
                case 1:
                    methods.countAllMonthlyReport();
                    break;
                case 2:
                    methods.countAllYearlyReport();
                    break;
                case 3:
                    methods.dataReconciliation();
                    break;
                case 4:
                    methods.informationAboutAllMonthlyReports();
                    break;
                case 5:
                    methods.informationAboutTheAnnualReport();
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

