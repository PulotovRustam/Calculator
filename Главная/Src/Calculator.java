import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String op = "";
        do {
            String input = sc.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] strings = input.trim().split("\\s+");
            if (strings.length != 3) {
                System.out.println("Output:");
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                continue;
            }
            try {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[2]);
                op = strings[1];
                if (!op.matches("[+\\-*/]")) {
                    System.out.println("Output:");
                    System.out.println("throws Exception //т.к. строка не является математической операцией");
                    break;
                }
                if (a > 10 || b > 10 || a < 1 || b < 1) {
                    System.out.println("Output:");
                    System.out.println("throws Exception");
                    continue;
                }
                System.out.println("Output:");
                System.out.println(operation(a, b, op));
            } catch (Exception e) {
                System.out.println("Output:");
                System.out.println("throws Exception");
            }
        } while (true);
    }

    private static int operation(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("throws Exception");
        }
    }
}
