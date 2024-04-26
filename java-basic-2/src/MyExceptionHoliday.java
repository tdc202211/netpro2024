import java.util.Scanner;

public class MyExceptionHoliday extends Exception {
    public static void main(String[] args) {

        MyExceptionHoliday myE = new MyExceptionHoliday();
        while (true) {
            try {
                System.out.println("日付を入力してください");
                Scanner scan = new Scanner(System.in);
                int num = scan.nextInt();

                if ((num - 4) % 7 == 0 || (num - 5) % 7 == 0) {
                    System.out.println("休日です");
                } else {
                    myE.test();
                }
            } catch (NoHolidayException e) {
                e.printStackTrace();
            }
        }
    }

    void test() throws NoHolidayException {
        if (true) {
            throw new NoHolidayException();
        }
    }
}
