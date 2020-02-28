package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        raceLauncher();
    }

    public static void raceLauncher() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter track length: ");
        int trackLength = scanner.nextInt();
        scanner.skip("\n");

        System.out.print("Enter snail amount: ");
        int snailParticipantAmount = scanner.nextInt();
        scanner.skip("\n");

        Race mainRace = new Race(trackLength);

        for (int i = 0; i < snailParticipantAmount; i++) {
            System.out.print("Enter snail " + (i + 1) + " name: ");
            String snailName = scanner.nextLine();
            mainRace.addSnail(new Snail(snailName));
        }

        mainRace.runRace();
    }
}
