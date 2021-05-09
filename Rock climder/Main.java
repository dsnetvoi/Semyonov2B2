import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Climber test = new Climber();

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину маршута: ");
        int length = in.nextInt();
        test.setLength(length);

        System.out.print("Введите максимальную вершину: ");
        int max_height = in.nextInt();
        test.setMax_height(max_height);

        System.out.print("Введите максимальный перепад трех ближайших вершин: ");
        int step = in.nextInt();
        test.setDifference3_step(step);

        test.printRoute();

        in.close();

    }
}