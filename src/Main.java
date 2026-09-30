import java.util.Random;

public class Main {

    // Створення масиву випадкових чисел від -100 до 100
    public int[] createArray(int n) {
        Random random = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        return array;
    }

    // 1. Номер мінімального за модулем елемента
    public int findMinAbsIndex(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив порожній");
        }

        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(array[minIndex])) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    // 2. Сума елементів між першим і останнім додатними елементами
    public int sumBetweenPositive(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив порожній");
        }

        int firstPositive = -1;
        int lastPositive = -1;

        // Знаходимо перший і останній додатні елементи
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (firstPositive == -1) {
                    firstPositive = i;
                }
                lastPositive = i;
            }
        }

        // Якщо додатних елементів менше двох
        if (firstPositive == -1 || firstPositive == lastPositive) {
            throw new IllegalArgumentException(
                    "Недостатньо додатних елементів для обчислення суми"
            );
        }

        int sum = 0;

        // Сума елементів між першим і останнім додатними
        for (int i = firstPositive + 1; i < lastPositive; i++) {
            sum += array[i];
        }

        return sum;
    }

    // Виведення масиву та результатів
    public void printResults() {
        int[] array = createArray(10);

        System.out.println("Масив:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int minAbsIndex = findMinAbsIndex(array);
        System.out.println("Номер мінімального за модулем елемента: "
                + minAbsIndex);

        try {
            int sum = sumBetweenPositive(array);
            System.out.println("Сума елементів між першим і останнім "
                    + "додатними елементами: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.printResults();
    }
}