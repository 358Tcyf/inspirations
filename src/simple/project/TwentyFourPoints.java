package simple.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwentyFourPoints {


    public static void main(String[] args) throws IOException {
        System.out.println("请输入4张牌");
        calculation(createNum(), createNum(), createNum(), createNum());
        if (start == end)
        {
            System.out.println("步骤1："+process1);
            System.out.println("步骤2："+process2);
            System.out.println("步骤3："+process3);
            System.out.println("算出来了");
        }
        else
            System.out.println("算不出来");
    }

    private static double createNum() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent;
        switch (inputContent = inputReader.readLine()) {
            case "A":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 10;
            case "a2":
                return 10;
            case "K":
                return 10;
            default:
                System.out.println("输入错误，再输一次");
                return createNum();
        }
    }

    private static int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    private static String print = "";
    private static double start = 0;
    private static double end = 24;
    private static String process1 = "";
    private static String process2 = "";
    private static String process3 = "";

    private static void calculation(double var1, double var2, double var3, double var4) {

        for (a1 = 1; a1 <= 2; a1++) {
            switch (a1) {
                case 1:
                    for (a2 = 1; a2 <= 3; a2++) {
                        for (a3 = 1; a3 <= 4; a3++) {
                            for (a4 = 1; a4 <= 4; a4++) {
                                for (a5 = 1; a5 <= 4; a5++) {
                                    start = fourNumber1(var1, var2, var3, var4);
                                    if (start == end) {
                                        break;
                                    } else {
                                        print = "";
                                    }
                                }
                                if (start == end)
                                    break;
                            }
                            if (start == end)
                                break;
                        }
                        if (start == end)
                            break;
                    }
                    return;
                case 2:
                    for (a6 = 1; a6 <= 4; a6++) {
                        for (a7 = 1; a7 <= 4; a7++) {
                            for (a8 = 1; a8 <= 3; a8++) {
                                for (a9 = 1; a9 <= 4; a9++) {
                                    for (a10 = 1; a10 <= 4; a10++) {
                                        start = fourNumber2(var1, var2, var3, var4);
                                        if (start == end) {
                                            break;
                                        } else {
                                            print = process1 = process2 = process3 = "";
                                        }
                                    }
                                    if (start == end)
                                        break;
                                }
                                if (start == end)
                                    break;
                            }
                            if (start == end)
                                break;
                        }
                        if (start == end)
                            break;
                    }
                    return;
                default:
            }
        }
    }

    private static double fourNumber1(double var1, double var2, double var3, double var4) {
        double sum = 0;
        switch (a2) {
            case 1:
                sum = twoNumber(twoNumber(var1, var2, a4), twoNumber(var3, var4, a5), a3);
                break;
            case 2:
                sum = twoNumber(twoNumber(var1, var3, a4), twoNumber(var2, var4, a5), a3);
                break;
            case 3:
                sum = twoNumber(twoNumber(var1, var4, a4), twoNumber(var2, var3, a5), a3);
                break;
        }
        return sum;
    }

    private static double fourNumber2(double var1, double var2, double var3, double var4) {
        double sum = 0;
        switch (a6) {
            case 1:
                sum = twoNumber(threeNumber(var1, var2, var3), var4, a7);
                break;
            case 2:
                sum = twoNumber(threeNumber(var1, var2, var4), var3, a7);
                break;
            case 3:
                sum = twoNumber(threeNumber(var1, var3, var4), var2, a7);
                break;
            case 4:
                sum = twoNumber(threeNumber(var2, var3, var4), var1, a7);
                break;
        }
        return sum;
    }

    private static double threeNumber(double var1, double var2, double var3) {
        double sum = 0;
        switch (a8) {
            case 1:
                sum = twoNumber(twoNumber(var1, var2, a10), var3, a9);
                break;
            case 2:
                sum = twoNumber(twoNumber(var1, var3, a10), var2, a9);
                break;
            case 3:
                sum = twoNumber(twoNumber(var2, var3, a10), var1, a9);
                break;
        }
        return sum;
    }

    private static double twoNumber(double var1, double var2, int aa) {
        double sum = 0;
        sum = randomSymbol(var1, var2, aa);
        return sum;
    }

    private static double randomSymbol(double var1, double var2, int aa) {
        double sum = 0;
        print += ("(");
        switch (aa) {
            case 1:
                sum = var1 + var2;
                print += (var1 + "+" + var2);
                break;
            case 2:
                sum = var1 - var2;
                print += (var1 + "-" + var2);
                break;
            case 3:
                sum = var1 * var2;
                print += (var1 + "×" + var2);
                break;
            case 4:
                sum = var1 / var2;
                print += (var1 + "÷" + var2);
                break;
        }
        print += (")");
        if (process1.equals("")) {
            process1 = print;
        } else if (process2.equals("")) {
            process2 = print;
        } else if (process3.equals("")) {
            process3 = print;
        }
        print = "";
        return sum;
    }
}
