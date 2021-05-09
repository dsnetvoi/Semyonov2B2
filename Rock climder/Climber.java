public class Climber {

    private int max_height;
    private int difference3_step;
    private int length;

    public int getMax_height() {
        return max_height;
    }

    public void setMax_height(int max_height) {
        this.max_height = max_height;
    }

    public int getDifference3_step() {
        return difference3_step;
    }

    public void setDifference3_step(int difference3_step) {
        // Если максимальный перепад трех ближайших вершин больше максимальной, то ограничить максимальной вершиной//
        if (difference3_step < max_height) {
            this.difference3_step = difference3_step;
        }
        else {
            this.difference3_step = max_height;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 3) {
            this.length = length;
        } else {
            System.out.println("Путь не может быть меньше трех вершин");
        }
    }

    public void printRoute () {
        int[] route = new int[length];
        int[] temp = new int[3];

        int max;
        int min;

        //Разница между двумя соседними вершинами//
        int difference = 0;

        // Генерация первых двух вершин//
        System.out.println(difference3_step);
        route[0] = difference3_step / 2 + (int) (Math.random()*difference3_step / 2);
        route[1] = (int) (Math.random()*difference3_step);

        if (route[0] > route[1]) {
            max = route[0];
            min = route[1];
        }
        else {
            max = route[1];
            min = route[0];
        }

        System.out.print(route[0] + " ");
        System.out.print(route[1] + " ");

        difference = Math.abs(max-min);

        for (int i = 2; i < length; i++) {
            // Границы высоты следующей вершины//
            // (difference3_step - difference) - дисперсия относительно макс и мин
            int a = negative(min, difference3_step - difference);
            int b = positive(max, difference3_step - difference);


            route[i] = Math.round((float)Math.random() * (b - a) + a);

            //Ищем мин. и максимум двух соседних вершин//
            if (route[i-1] > route[i]) {
                max = route[i-1];
                min = route[i];
            }
            else {
                max = route[i];
                min = route[i-1];
            }

            difference = Math.abs(max-min);

            System.out.print(route[i] + " ");

        }


    }

    //Если границы смещаются за пределы максимальной вершиной, то ограничить  этой максимальной вершиной//
    private int positive (int max_f, int diff) {
        if (max_f+diff > max_height) {
             return max_height;
        }
        else
            return max_f+diff;
    }

    //Если границы смещаются в отрицательный диапазон, то ограничить нулем//
    private int negative (int min_f, int diff) {
        if (min_f-diff < 0) {
            return 0;
        }
        else
            return min_f-diff;
    }


    public Climber()
    {

    }

}