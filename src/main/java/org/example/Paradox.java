package org.example;

import java.util.HashMap;
import java.util.Random;

/**
 * PPPPPP
 */
public class Paradox {
    private int qty_games = 0;
    private HashMap<Integer,Boolean> hashMap = null;

    private int statPrizeDoor0 = 0;
    private int statPrizeDoor1 = 0;
    private int statPrizeDoor2 = 0;
    private int statFirstChoiceDoor0 = 0;
    private int statFirstChoiceDoor1 = 0;
    private int statFirstChoiceDoor2 = 0;
    private int statChangeDoor = 0;
    private int statWin = 0;
    private int statIf1 = 0;
    private int statIf2 = 0;
    private int statIf3 = 0;
    private int statIf4 = 0;

    private int statPrizeDoor0_ = 0;
    private int statPrizeDoor1_ = 0;
    private int statPrizeDoor2_ = 0;

    /**
     * EEEEEEEEEEEEE
     * @param qty_games EEEEEE
     */
    public Paradox(int qty_games) {
        this.qty_games = qty_games;
        hashMap = new HashMap<>();

        for(int i=0; i<qty_games; i++) {
            play(i);
        }
        printStatistic();
        printHashMap();
    }

    /**
     * FFFFFFFFFFF
     * @param n FFFFF
     */
    private void play(int n) {
        boolean[] doors = getDoors();
        int doorFirstChoice = (new Random()).nextInt(3);
        boolean change = true;
        //boolean change = (new Random()).nextBoolean();

        setBeginStatistic(doors, doorFirstChoice, change);

        int prizeDoor = (doors[0]) ? 0 : ((doors[1]) ? 1 : 2);
        // самопроверка prizeDoor
        if(prizeDoor == 0) statPrizeDoor0_++;
        else if(prizeDoor == 1) statPrizeDoor1_++;
        else if(prizeDoor == 2) statPrizeDoor2_++;

        if(doorFirstChoice != prizeDoor && change) {
            hashMap.put(n,true);  statIf1++; statWin++;
        } else if(doorFirstChoice == prizeDoor && !change) {
            hashMap.put(n,true);  statIf2++; statWin++;
        } else if(doorFirstChoice == prizeDoor && change) {
            hashMap.put(n,false); statIf3++;
        } else if(doorFirstChoice != prizeDoor && !change) {
            hashMap.put(n,false); statIf4++;
        }
    }

    private boolean[] getDoors() {
        boolean[] doors = new boolean[3];
        int n = (new Random()).nextInt(3);
        doors[n] = true;
        return doors;
    }

    // Статистика входных данных
    private void setBeginStatistic(boolean[] doors, int doorFirstChoice, boolean change) {
        if(doors[0]) statPrizeDoor0++;
        if(doors[1]) statPrizeDoor1++;
        if(doors[2]) statPrizeDoor2++;
        if(doorFirstChoice == 0) statFirstChoiceDoor0++;
        if(doorFirstChoice == 1) statFirstChoiceDoor1++;
        if(doorFirstChoice == 2) statFirstChoiceDoor2++;
        if(change) statChangeDoor++;
    }

    // Статистика входных данных - печать
    private void printStatistic() {
        System.out.printf("Статистика распределения приза по дверям в процентах: 1) %.2f; 2) %.2f; 3) %.2f. \n"
                , 100.0 * statPrizeDoor0 / qty_games, 100.0 * statPrizeDoor1 / qty_games, 100.0 * statPrizeDoor2 / qty_games);
        System.out.printf("Статистика распределения приза по дверям в процентах: 1) %.2f; 2) %.2f; 3) %.2f. \n"
                , 100.0 * statPrizeDoor0_ / qty_games, 100.0 * statPrizeDoor1_ / qty_games, 100.0 * statPrizeDoor2_ / qty_games);
        System.out.printf("Статистика выбора двери в первый раз     в процентах: 1) %.2f; 2) %.2f; 3) %.2f. \n"
                , 100.0 * statFirstChoiceDoor0 / qty_games, 100.0 * statFirstChoiceDoor1 / qty_games, 100.0 * statFirstChoiceDoor2 / qty_games);
        System.out.printf("Статистика смены выбора во второй раз    в процентах:    %.2f. \n", 100.0 * statChangeDoor / qty_games);
        System.out.printf("Статистика побед в процентах: %.2f. \n", 100.0 * statWin / qty_games);
        System.out.printf("Статистика распределения по УСЛОВиЯМ     в процентах: 1) %.2f; 2) %.2f; 3) %.2f; 4) %.2f. \n"
                , 100.0 * statIf1 / qty_games, 100.0 * statIf2 / qty_games, 100.0 * statIf3 / qty_games, 100.0 * statIf4 / qty_games);
        System.out.println("Пронаблюдал. Пародокс 50/50 рассуждает о дверях, но игрок ищет подарки, равномерность которых по 3 дверям обеспечивает ИСТОЧНИК, которому без разницы кто какие двери открыл и что знает.");
    }

    private void printHashMap() {
        int qty = hashMap.size();
        int minStep = hashMap.keySet().stream().min(Integer::compare).get();
        int maxStep = hashMap.keySet().stream().max(Integer::compare).get();
        long countWin = hashMap.values().stream().filter(b -> b).count();
        System.out.printf("HashMap: Кол-во побед %d; Кол-во поражений %d; мин. шаг %d; макс. шаг %d; Кол-во шагов %d; \n"
                , countWin, qty - countWin, minStep, maxStep, qty );
    }

    /**
     * myEmpty() чтобы javadoc не ругался
     */
    public void myEmpty() {}
}
