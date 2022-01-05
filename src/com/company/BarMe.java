package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BarMe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your current location:");
        System.out.print("length: ");
        double length = scanner.nextDouble();
        System.out.print("width: ");
        double width = scanner.nextDouble();
        printOptions(length, width);
    }

    public static void printOptions(double length, double width) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an potion:");
        System.out.println("(1) List all restaurants;");
        System.out.println("(2) List of open restaurants;");
        System.out.println("(3) Map of the nearest restaurant;");
        int inputOption = scanner.nextInt();

        if (inputOption == 1) {
            firstOption(length, width);
        } else if (inputOption == 2) {
            secondOption();
        }
    }

    public static void firstOption(double length, double width) {
//        int[] arrangedMeters = arrangeTheMeters(length, width);
//        for (int i = 0; i < arrangedMeters.length; i++) {
//            for (i = 0; i < workTime().length; i++) {
//                System.out.println(workTime()[i] + " - " + arrangedMeters[i]);
//            }
//        }

        arrangeTheMeters(length, width);
    }
    private static void arrangeTheMeters(double length, double width) {
        int[] meters = getMeters(length, width);
        int swap = 0;
        for (int i = 0; i < meters.length; i++) {
            for (int j = i + 1; j < meters.length; j++) {
                if (meters[i] > meters[j]) {
                    swap = meters[i];
                    meters[i] = meters[j];
                    meters[j] = swap;
                }
            }
        }
        System.out.println(Arrays.toString(meters));
    }
    private static double[] getLengths() {
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

    public static int[] getMeters(double length, double width) {
        double[] lengths = getLengths();
        double[] widths = getWidths();

        int k = 0;
        int[] meters = new int[lengths.length];
        for (int i = 0; i < lengths.length; i++) {
            for (i = 0; i < widths.length; i++) {
                int radius = 6371;
                double longitude = Math.toRadians(length - lengths[i]);
                double latitude = Math.toRadians(width - widths[i]);
                double a = Math.sin(longitude / 2) * Math.sin(longitude / 2) + Math.cos(Math.toRadians(length))
                        * Math.cos(Math.toRadians(lengths[i])) * Math.sin(latitude / 2) * Math.sin(latitude / 2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                double d = (radius * c) * 1000;
                int getMeters = (int) Math.round(d);
                meters[k] = getMeters;
                k++;
            }
        }
        return meters;
    }
    public static String[] restaurantNames (){
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



    private static String[] workTime() {
        Scanner scanner = new Scanner(System.in);
        String piаzzaItalia = "Piazza Italia                    - 12:00 - 21:00";
        String zlatenDrakon = "Китайски ресторант Златен Дракон - 11:30 - 22:00";
        String nashentsi = "Нашенци                          - 11:00 - 23:00";
        String theOldHouse = "Старата къща                     - 08:00 - 23:00";
        String pintata = "Пинтата                          - 11:00 - 0:00";
        String bulgare = "Българе                          - 11:00 - 0:00";
        String vili = "Вили                             - 08:00 - 0:00";
        String metalik = "Металик                          - 09:00 - 0:00";
        String hemus = "Хемус                            - 07:00 - 0:00";
        String tracianPrinces = "Тракийска Принцеса               - 08:00 - 0:00";
        String[] workTime = {piаzzaItalia, zlatenDrakon, nashentsi, theOldHouse, pintata, bulgare, vili, metalik, hemus,
                 tracianPrinces};
        return workTime;
    }


    public static void secondOption() {
        Scanner scanner = new Scanner(System.in);
        String pintata = "Пинтата                          - 11:00 - 0:00";
        String nashentsi = "Нашенци                          - 11:00 - 23:00";
        String bulgare = "Българе                          - 11:00 - 0:00";
        String vili = "Вили                             - 08:00 - 0:00";
        String metalik = "Металик                          - 09:00 - 0:00";
        String hemus = "Хемус                            - 07:00 - 0:00";
        String zlatenDrakon = "Китайски ресторант Златен Дракон - 11:30 - 22:00";
        String piаzzaItalia = "Piazza Italia                    - 12:00 - 21:00";
        String theOldHouse = "Старата къща                     - 08:00 - 23:00";
        String tracianPrinces = "Тракийска Принцеса               - 08:00 - 0:00";

        System.out.println("Please enter the current time:");
        System.out.print("Hour: ");
        int hour = scanner.nextInt();
        System.out.print("Minutes: ");
        int minutes = scanner.nextInt();

        if (hour > 0 && hour < 21) {
            System.out.println(piаzzaItalia);
            System.out.println(zlatenDrakon);
            System.out.println(theOldHouse);
            System.out.println(nashentsi);
            System.out.println(pintata);
            System.out.println(bulgare);
            System.out.println(vili);
            System.out.println(metalik);
            System.out.println(hemus);
            System.out.println(tracianPrinces);
        } else if (hour > 0 && hour < 22) {
            System.out.println(zlatenDrakon);
            System.out.println(theOldHouse);
            System.out.println(nashentsi);
            System.out.println(pintata);
            System.out.println(bulgare);
            System.out.println(vili);
            System.out.println(metalik);
            System.out.println(hemus);
            System.out.println(tracianPrinces);
        } else if (hour > 0 && hour < 23) {
            System.out.println(theOldHouse);
            System.out.println(nashentsi);
            System.out.println(pintata);
            System.out.println(bulgare);
            System.out.println(vili);
            System.out.println(metalik);
            System.out.println(hemus);
            System.out.println(tracianPrinces);
        } else if (hour == 23) {
            System.out.println(pintata);
            System.out.println(bulgare);
            System.out.println(vili);
            System.out.println(metalik);
            System.out.println(hemus);
            System.out.println(tracianPrinces);
        } else if (hour < 0 || hour > 23) {
            System.out.println("There is no such hour.");
        }
    }
}
