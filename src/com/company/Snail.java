package com.company;

public class Snail {
    public static String distanceCharacter = ">";

    private String _name;

    public String getName() {
        return _name;
    }

    private int _speedMin;
    private int _speedMax;

    private int _distanceTraveled = 0;

    public int getDistanceTraveled() {
        return _distanceTraveled;
    }

    public Snail(String name) {
        _name = name;
        _speedMin = hRandom.getRandomNumberInRange(0, 2);
        _speedMax = hRandom.getRandomNumberInRange(_speedMin, 3);

        if (_speedMin == _speedMax) {
            _speedMin--;
        }
    }

    public void runTick() {
        int tickDistance = hRandom.getRandomNumberInRange(_speedMin, _speedMax);
        _distanceTraveled += tickDistance;
    }

    public void drawDistanceTraveled() {
        String visibleDistance = "";
        for (int i = 0; i < _distanceTraveled; i++) {
            visibleDistance += distanceCharacter;
        }

        System.out.println(_name);
        System.out.println(visibleDistance);
    }
}
