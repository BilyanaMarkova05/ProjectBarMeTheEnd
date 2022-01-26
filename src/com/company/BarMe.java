package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BarMe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Въведете текущата си локация:");
        System.out.print("дължина: ");
        double length = scanner.nextDouble();
        System.out.print("ширина: ");
        double width = scanner.nextDouble();
        printOptions(length, width);
    }

    public static void printOptions(double length, double width) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Изберете опция:");
        System.out.println("(1) Списък на всички заведения;");
        System.out.println("(2) Списък на всички отворени заведения;");
        System.out.println("(3) Карта;");
        int inputOption = scanner.nextInt();

        if (inputOption == 1) {
            firstOption(length, width);
        } else if (inputOption == 2) {
            secondOption();
        } else if (inputOption == 3) {
            thirdOption();
        } else if (inputOption < 0 || inputOption > 3) {
            System.out.println("Няма такава опция.");
        }
    }

    public static void firstOption(double length, double width) {
        String[] names = restaurantNames();
        int[] meters = getMeters(length, width);
        String[] meter = new String[meters.length];
        for (int i = 0; i < meters.length; i++) {
            meter[i] = Integer.toString(meters[i]);
        }
        String[] workTime = workTime();
        String[][] data = new String[10][3];
        for (int row = 0; row < data.length; row++) {
            System.out.print(row + 1 + "." + " ");
            for (int col = 0; col < data[0].length; col++) {
                data[row][0] = names[row];
                data[row][1] = workTime[row];
                data[row][2] = meter[row];
                System.out.print(data[row][col] + " ");
            }
            System.out.print("м");
            System.out.println();
        }
    }

    public static void secondOption() {
        Scanner scanner = new Scanner(System.in);
        String[] workTime = workTime();
        String[] names = restaurantNames();

        System.out.println("Моля въведете сегашния час:");
        System.out.print("Час: ");
        int hour = scanner.nextInt();
        System.out.print("Минути: ");
        int minutes = scanner.nextInt();

        if (hour > 0 && hour < 21) {
            for (int i = 0; i < workTime.length; i++) {
                System.out.println(i + 1 + "." + " " + names[i] + workTime[i]);
            }
        } else if (hour > 0 && hour < 22) {
            for (int i = 1; i < workTime.length; i++) {
                System.out.println(i + 1 + "." + " " + names[i] + workTime[i]);
            }
        } else if (hour > 0 && hour < 23) {
            for (int i = 2; i < workTime.length; i++) {
                System.out.println(i + 1 + "." + " " + names[i] + workTime[i]);
            }
        } else if (hour == 23) {
            for (int i = 4; i < workTime.length; i++) {
                System.out.println(i + 1 + "." + " " + names[i] + workTime[i]);
            }
        } else if (hour < 0 || hour > 23) {
            System.out.println("Няма такъв час.");
        }
    }

    public static void thirdOption() {
        String[] names = restaurantNames();
        printMap();
        System.out.println();
        System.out.println("Х - ти си тук");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + 1 + ". " + names[i]);
        }
    }

    public static String[][] printMap() {
        String[][] map = new String[11][31];
        System.out.println();
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] = "  ";
            }
        }
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                map[0][col] = "--";
                map[row][0] = "|";
                map[5][16] = "X ";
                map[row][30] = "|";
                map[10][col] = "--";
                System.out.print(map[row][col]);
            }
            System.out.println();
        }
        return map;
    }

    public static int[] getMeters(double length, double width) {
        double[] lengths = getLengths();
        double[] widths = getWidths();
        int[] getMeters = new int[lengths.length];
        int k = 0;
        for (int i = 0; i < lengths.length; i++) {
            for (i = 0; i < widths.length; i++) {
                int radius = 6371;
                double longitude = Math.toRadians(length - lengths[i]);
                double latitude = Math.toRadians(width - widths[i]);
                double a = Math.sin(longitude / 2) * Math.sin(longitude / 2) + Math.cos(Math.toRadians(length))
                        * Math.cos(Math.toRadians(lengths[i])) * Math.sin(latitude / 2) * Math.sin(latitude / 2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                double d = (radius * c) * 1000;
                getMeters[i] = (int) Math.round(d);
                k++;
            }
        }
        return getMeters;
    }

    private static double[] getWidths() {
        double thePintWidth = 23.551188;
        double nashentsiWidth = 23.5560805;
        double bulgareWidth = 23.5524481;
        double viliWidth = 23.5524481;
        double metalikWidth = 23.5526083;
        double hemusWidth = 23.5482126;
        double zlatenDrakonWidth = 23.5480470;
        double piazzaItaliaWidth = 23.5488371;
        double theOldHouseWidth = 23.5498424;
        double tracianPrincesWidth = 23.5521022;
        double[] widths = {piazzaItaliaWidth, zlatenDrakonWidth, nashentsiWidth, theOldHouseWidth, thePintWidth,
                bulgareWidth, viliWidth, metalikWidth, hemusWidth, tracianPrincesWidth};
        return widths;
    }

    public static double[] getLengths() {
        double thePintLength = 43.206455;
        double nashentsiLength = 43.2004764;
        double bulgareLength = 43.1996525;
        double viliLength = 43.2063501;
        double metalikLength = 43.2058534;
        double hemusLength = 43.2020833;
        double zlatenDrakonLength = 43.2050382;
        double piazzaItaliaLength = 43.2033787;
        double theOldHouseLength = 43.2025569;
        double tracianPrincesLength = 43.2046545;
        return new double[]{piazzaItaliaLength, zlatenDrakonLength, nashentsiLength, theOldHouseLength, thePintLength,
                bulgareLength, viliLength, metalikLength, hemusLength, tracianPrincesLength};
    }

    private static String[] workTime() {
        String piаzzaItalia = " (12:00 - 21:00) ";
        String zlatenDrakon = " (11:30 - 22:00) ";
        String nashentsi = " (11:00 - 23:00) ";
        String theOldHouse = " (08:00 - 23:00) ";
        String pintata = " (11:00 - 0:00) ";
        String bulgare = " (11:00 - 0:00) ";
        String vili = " (08:00 - 0:00) ";
        String metalik = " (09:00 - 0:00) ";
        String hemus = " (07:00 - 0:00) ";
        String tracianPrinces = " (08:00 - 0:00) ";
        String[] workTime = {piаzzaItalia, zlatenDrakon, nashentsi, theOldHouse, pintata, bulgare, vili, metalik, hemus,
                tracianPrinces};
        return workTime;
    }

    public static String[] restaurantNames() {
        String piаzzaItalia = "Piazza Italia";
        String zlatenDrakon = "Китайски ресторант Златен Дракон";
        String nashentsi = "Нашенци";
        String theOldHouse = "Старата къща";
        String pintata = "Пинтата";
        String bulgare = "Българе";
        String vili = "Вили";
        String metalik = "Металик";
        String hemus = "Хемус";
        String tracianPrinces = "Тракийска Принцеса";
        String[] restaurantNames = {piаzzaItalia, zlatenDrakon, nashentsi, theOldHouse, pintata, bulgare, vili, metalik,
                hemus, tracianPrinces};
        return restaurantNames;
    }
}
