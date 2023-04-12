import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReportEngine {

    private ArrayList<String> nameMonth = new ArrayList<>();
    {
        Collections.addAll(nameMonth, "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
                "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
    }

    private ArrayList<MonthlyReport> monthlyReport;
    private ArrayList<YearlyReport> yearlyReport;
    ReportEngine(){
        monthlyReport = new ArrayList<>();
        yearlyReport = new ArrayList<>();
    }
    void addMonthlyReport(String path){
        monthlyReport.add(new MonthlyReport());
        MonthlyReport report = monthlyReport.get(monthlyReport.size() - 1);
        String year = "";
        String month = "";

        String[] reports = path.split("\\W");
        for (int i = 0; i < reports[reports.length - 2].length(); i++) {
            char s = reports[reports.length - 2].charAt(i);
            if (i < 4){
                year += String.valueOf(s);
            }else {
                month += String.valueOf(s);
            }
        }
        report.setMonth(Integer.parseInt(month));
        report.setYear(Integer.parseInt(year));


        List<String> fileContents = readFileContents(path);
        for (int i = 1; i < fileContents.size(); i++){
            report.getRecords().add(new MonthlyRecord());
            int position = report.getRecords().size() - 1;
            String[] data = fileContents.get(i).split("[,]");
            report.getRecords().get(position).setExpense(Boolean.parseBoolean(data[1].toLowerCase(Locale.ROOT)));
            report.getRecords().get(position).setItemName(data[0]);
            report.getRecords().get(position).setQuantity(Integer.parseInt(data[2]));
            report.getRecords().get(position).setSumOfOne(Double.parseDouble(data[3]));

        }
    }

    void addYearlyReport(String path){
        yearlyReport.add(new YearlyReport());
        YearlyReport report = yearlyReport.get(yearlyReport.size() - 1);

        String[] reports = path.split("\\W");
        report.setYear(Integer.parseInt(reports[reports.length - 2]));

        List<String> fileContents = readFileContents(path);
        for (int i = 1; i < fileContents.size(); i++) {
            report.getRecords().add(new YearlyRecord());
            int position = report.getRecords().size() - 1;
            String[] data = fileContents.get(i).split("[,]");
            report.getRecords().get(position).setAmount(Double.parseDouble(data[1]));
            report.getRecords().get(position).setMonthNumber(Integer.parseInt(data[0]));
            report.getRecords().get(position).setExpense(Boolean.parseBoolean(data[2].replaceAll("[^a-zA-Z]", "")));
        }
    }


    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    void countAllMonthlyReport(){
        File folder = new File("./resources/");
        File[] listOfFiles = folder.listFiles();
        String path = "resources/";
        addMonthlyReport(path + listOfFiles[0].getName());
        addMonthlyReport(path + listOfFiles[1].getName());
        addMonthlyReport(path + listOfFiles[2].getName());
        System.out.println("файлы успешно считаны");
    }
    void countAllYearlyReport(){
        File folder = new File("./resources/");
        File[] listOfFiles = folder.listFiles();
        String path = "resources/";
        addYearlyReport(path + listOfFiles[3].getName());
        System.out.println("файлы успешно считаны");
    }
    void dataReconciliation() {
        if (yearlyReport.isEmpty() || monthlyReport.isEmpty()) {
            System.out.println("Сначала считайте месячные/годовые очтеты");
            return;
        }
        HashMap<Integer, Double> monthExpense = new HashMap<>();
        HashMap<Integer, Double> monthIncome = new HashMap<>();
        boolean isEmpty = true;
        for (MonthlyReport report : monthlyReport) {
            double expense = 0;
            double income = 0;
            for (MonthlyRecord monthlyRecord : report.getRecords()) {
                if (monthlyRecord.getExpense()) {
                    expense += monthlyRecord.getQuantity() * monthlyRecord.getSumOfOne();
                } else {
                    income += monthlyRecord.getQuantity() * monthlyRecord.getSumOfOne();
                }
            }
            monthExpense.put(report.getMonth(), expense);
            monthIncome.put(report.getMonth(), income);
        }
        for (YearlyReport yearlyReport : yearlyReport) {
            for (YearlyRecord yearlyRecord : yearlyReport.getRecords()) {
                if (yearlyRecord.getExpense()) {
                    if (yearlyRecord.getAmount() == monthExpense.get(yearlyRecord.getMonthNumber())) {

                    }else {
                        System.out.println("обнаружено несоответствие в месеце: " + yearlyRecord.getMonthNumber());
                        isEmpty = false;
                    }
                } else {
                    if (yearlyRecord.getAmount() == monthIncome.get(yearlyRecord.getMonthNumber())) {

                    }else {
                        System.out.println("обнаружено несоответствие в месеце: " + yearlyRecord.getMonthNumber());
                        isEmpty = false;
                    }
                }
            }
        }
        if (isEmpty) {
            System.out.println("операция успешно завершена");
        }
        }


        void informationAboutAllMonthlyReports () {
            if (monthlyReport.isEmpty()) {
                System.out.println("Сначала считайте месячные очтеты");
                return;
            }

            for (MonthlyReport reportMonth : monthlyReport) {
                System.out.println(nameMonth.get(reportMonth.getMonth() - 1));
                double expenseTrue = 0;
                double expenseFalse = 0;
                String nameFalse = null;
                String nameTrue = null;
                for (MonthlyRecord monthlyRecord : reportMonth.getRecords()) {
                    if (
                            monthlyRecord.getExpense()
                                    && monthlyRecord.getQuantity() * monthlyRecord.getSumOfOne() > expenseTrue
                    ) {
                        expenseTrue = monthlyRecord.getQuantity() * monthlyRecord.getSumOfOne();
                        nameTrue = monthlyRecord.getItemName();
                    } else if ((!(monthlyRecord.getExpense()))
                            && monthlyRecord.getQuantity() * monthlyRecord.getSumOfOne() > expenseFalse) {
                        expenseFalse = monthlyRecord.getQuantity() * monthlyRecord.getSumOfOne();
                        nameFalse = monthlyRecord.getItemName();
                    }
                }
                System.out.println("Самый прибыльный товар: " + nameFalse + " " + expenseFalse);
                System.out.println("Самая большая трата: " + nameTrue + " " + expenseTrue);
            }
        }

        void informationAboutTheAnnualReport () {
            if (yearlyReport.isEmpty()) {
                System.out.println("Сначала считайте годовые очтеты");
                return;
            }
            for (YearlyReport yearlyReport : yearlyReport) {
                HashMap<Integer, Double> expenses = new HashMap<>();
                HashMap<Integer, Double> income = new HashMap<>();
                double expensesSum = 0;
                double incomeSum = 0;
                for (YearlyRecord yearlyRecord : yearlyReport.getRecords()) {
                    if (yearlyRecord.getExpense()) {
                        expenses.put(yearlyRecord.getMonthNumber(), yearlyRecord.getAmount());
                        expensesSum += yearlyRecord.getAmount();
                    } else {
                        income.put(yearlyRecord.getMonthNumber(), yearlyRecord.getAmount());
                        incomeSum += yearlyRecord.getAmount();
                    }
                }
                for (int i = 0; i < 12; i++) {
                    if (expenses.containsKey(i + 1) && income.containsKey(i + 1)) {
                        System.out.println("год: " + yearlyReport.getYear() + "\n"
                                + "Прибыль за: " + nameMonth.get(i) + " составила: " + (income.get(i + 1) - expenses.get(i + 1)));

                    }
                }
                System.out.println("Средний расход за все месяцы в году: " + (expensesSum / 12));
                System.out.println("Средний доход за все месяцы в году: " + (incomeSum / 12));
            }
        }


    }

