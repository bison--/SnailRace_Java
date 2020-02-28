package com.company;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public int tickSleep = 1000;
    private int trackLength;
    private List<Snail> snailsInRace = new ArrayList<>();

    public void addSnail(Snail snail) {
        snailsInRace.add(snail);
    }

    public Race(int trackLength) {
        this.trackLength = trackLength;
    }

    public void runRace() {
        if (snailsInRace.size() <= 1) {
            throw new RuntimeException("There must be at least 2 snails in the race, currently " + snailsInRace.size());
        }

        while (!hasWinner()) {
            raceTick();
            drawRaceState();

            try {
                Thread.sleep(tickSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        drawWinner();
    }

    public void raceTick() {
        for (Snail snail : snailsInRace) {
            snail.runTick();
        }
    }

    public boolean hasWinner() {
        boolean hasWinner = false;

        for (int i = 0; i < snailsInRace.size(); i++) {
            if (snailsInRace.get(i).getDistanceTraveled() >= trackLength) {
                hasWinner = true;
                break;
            }
        }

        return hasWinner;
    }

    public Snail getWinner() {
        for (Snail snail : snailsInRace) {
            if (snail.getDistanceTraveled() >= trackLength) {
                return snail;
            }
        }

        throw new RuntimeException("THERE IS NO WINNER (YET!)");
    }

    public void drawRaceState() {
        hUtils.clearTerminal();

        for (Snail snail : snailsInRace) {
            snail.drawDistanceTraveled();
        }
    }

    public void drawWinner() {
        System.out.println("");
        System.out.println("");
        System.out.println("Winner is: ");
        System.out.println("##########");
        System.out.println("# " + getWinner().getName());
        System.out.println("##########");
        System.out.println("");
    }
}
