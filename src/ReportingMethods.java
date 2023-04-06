import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ReportingMethods {

    ReportStorage storage = new ReportStorage();

    Scanner s = new Scanner(System.in);

    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }

    void countAllMonthlyReport(){
        int count = 1;
        while (true){
            System.out.println("для выхода введите: exit\n" +
                    "введите путь файлу: " + count);
            String name = s.nextLine();
            if (name.equals("exit")){
                return;
            }else {
                storage.monthlyReports.add(new MonthlyReport(name));
                count++;
            }

        }
    }
    void countAllYearlyReport(){
        int count = 1;
        while (true){
            System.out.println("для выхода введите: exit\n" +
                    "введите путь файлу: " + count);
            String name = s.nextLine();
            if (name.equals("exit")){
                return;
            }else {
                storage.yearlyReports.add(new YearlyReport(name));
                count++;
            }

        }
    }
}
