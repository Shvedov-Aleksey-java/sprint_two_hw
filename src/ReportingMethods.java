import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ReportingMethods {
    Scanner s = new Scanner(System.in);
    private ArrayList<PositionYear> positionYears;
    private ArrayList<PositionMonth> positionMonths;
    ReportingMethods(){
        this.positionYears = new ArrayList<>();
        this.positionMonths = new ArrayList<>();
    }

    void countAllMonthlyReport(){
        for (int i = 0; i < 3; i++) {
            System.out.println("������� ���� �����: " + (i + 1));
            String path = s.nextLine();
            positionMonths.add(new PositionMonth(path));
        }
    }
    void countAllYearlyReport(){
        System.out.println("������� ���� �����:");
        String path = s.nextLine();
        positionYears.add(new PositionYear(path));
    }
    void dataReconciliation(){
        HashMap<Integer, Double> expensesTrue = new HashMap<>();
        HashMap<Integer, Double> expensesFalse = new HashMap<>();
        boolean check = false;
        for (PositionMonth position:positionMonths) {
            int monthNumber = position.getMonthNumber();
            double expenseTrue = 0;
            double expenseFalse = 0;
            for (int i = 0; i < position.getItemName().size(); i++) {
                if (position.getIsExpense().get(i)){
                    expenseTrue += position.getQuantity().get(i) * position.getSumOfOne().get(i);
                }else {
                    expenseFalse += position.getQuantity().get(i) * position.getSumOfOne().get(i);
                }
            }
            expensesTrue.put(monthNumber, expenseTrue);
            expensesFalse.put(monthNumber, expenseFalse);
        }

        for (int i = 0; i < positionYears.get(0).getMonthNumber().size(); i++) {
            int mothNumber = positionYears.get(0).getMonthNumber().get(i);
            boolean isMoth = positionYears.get(0).getIsExpense().get(i);
            double amount = positionYears.get(0).getAmount().get(i);
            if (isMoth){
                if (expensesTrue.containsKey(mothNumber)){
                    if (amount != expensesTrue.get(mothNumber)){
                        System.out.println("���������� �������������� � ������: " + mothNumber);
                        check = true;
                    }
                }
            }else {
                if (expensesFalse.containsKey(mothNumber)){
                    if (amount != expensesFalse.get(mothNumber)){
                        System.out.println("���������� �������������� � ������: " + mothNumber);
                        check = true;
                    }
                }
            }
        }
        if (!(check)) System.out.println("�������� ������� ���������");

        }
        void informationAboutAllMonthlyReports(){
            ArrayList<String> nameMonth = new ArrayList<>();
            Collections.addAll(nameMonth, "������", "�������", "����", "������", "���", "����", "����",
                    "������", "��������", "�������", "������", "�������");
            for (PositionMonth position: positionMonths){
                System.out.println(nameMonth.get(position.getMonthNumber() - 1));
                double expenseTrue = 0;
                double expenseFalse = 0;
                String nameFalse = null;
                String nameTrue = null;
                for (int i = 0; i < position.getItemName().size(); i++) {
                    if (position.getIsExpense().get(i)){
                        if (expenseTrue < position.getQuantity().get(i) * position.getSumOfOne().get(i)){
                            expenseTrue = position.getQuantity().get(i) * position.getSumOfOne().get(i);
                            nameTrue = position.getItemName().get(i);
                        }
                    }else {
                        if (expenseFalse < position.getQuantity().get(i) * position.getSumOfOne().get(i)){
                            expenseFalse = position.getQuantity().get(i) * position.getSumOfOne().get(i);
                            nameFalse = position.getItemName().get(i);
                        }
                    }
                }
                System.out.println("����� ���������� �����: " + nameFalse + "-" + expenseFalse);
                System.out.println("����� ������� �����: " + nameTrue + "-" + expenseTrue);
            }
        }
        void informationAboutTheAnnualReport(){
            ArrayList<String> nameMonth = new ArrayList<>();
            Collections.addAll(nameMonth, "������", "�������", "����", "������", "���", "����", "����",
                    "������", "��������", "�������", "������", "�������");
            System.out.println("���: " + positionYears.get(0).getYearNumber());
            double expenses = 0;
            double income = 0;
            for (PositionMonth position:positionMonths) {
                int monthNumber = position.getMonthNumber();
                double expenseTrue = 0;
                double expenseFalse = 0;
                for (int i = 0; i < position.getItemName().size(); i++) {
                    if (position.getIsExpense().get(i)){
                        expenseTrue += position.getQuantity().get(i) * position.getSumOfOne().get(i);
                    }else {
                        expenseFalse += position.getQuantity().get(i) * position.getSumOfOne().get(i);
                    }
                }
                expenses += expenseTrue;
                income += expenseFalse;
                System.out.println("������� ��: " + nameMonth.get(monthNumber - 1) + " ���������: " + (expenseTrue - expenseFalse));
            }
            System.out.println("������� ������ �� ��� ������ � ����: " + (expenses / 12));
            System.out.println("������� ����� �� ��� ������ � ����: " + (income / 12));

        }


    }

