package ru.kalash.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;


public class Casino {
    private static Random random = new Random();
    private static int sum = 0;
    private int maxSum;
    private static String[] resultArr = {"Выигрыш", "Проигрыш"};

    public Casino(int maxSum) {
        this.maxSum = maxSum;
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            RunAnnotation runAnnotation = method.getDeclaredAnnotation(RunAnnotation.class);
            if (runAnnotation != null) {
                try {
                    method.invoke(this);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @RunAnnotation
    public int poker() {
        sum = random.nextInt(this.maxSum);
        printResult("Покер", sum);
        return sum;
    }

    public int roulette() {
        sum = random.nextInt(this.maxSum);
        printResult("Рулетка", sum);
        return sum;
    }

    @RunAnnotation
    public int oneArmedBandit() {
        sum = random.nextInt(this.maxSum);
        printResult("Однорукий бандит", sum);
        return sum;
    }

    public int blackJack() {
        sum = random.nextInt(this.maxSum);
        printResult("Блэкджек", sum);
        return sum;
    }

    @RunAnnotation
    public int wheelFortune() {
        sum = random.nextInt(this.maxSum);
        printResult("Колесо фортуны", sum);
        return sum;
    }

    public int baccara() {
        sum = random.nextInt(this.maxSum);
        printResult("Баккара", sum);
        return sum;
    }

    public void printResult(String nameGame, int sum) {
        System.out.printf("%s - %s - %d\n",
                nameGame,
                resultArr[random.nextInt(2)],
                sum);

    }
}
