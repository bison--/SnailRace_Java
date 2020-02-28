package com.company;

import java.io.IOException;

public class hUtils {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String classPath = System.getProperty("java.class.path");

    public static boolean isIntelliJ() {
        return classPath.contains("idea_rt.jar");
    }

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static boolean isSolaris() {
        return OS.contains("sunos");
    }

    public static void clearTerminal() {
        if (isIntelliJ()) {
            clearTerminalIntelliJ();
        } else if (isWindows()) {
            try {
                clearTerminalWindows();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } else if (isUnix() || isMac() || isSolaris()) {
            // TODO: check if this works for all OSes
            clearTerminalUnix();
        }

    }

    private static void clearTerminalIntelliJ() {
        // fake a clear, the Jetbrains terminal does not know clear!
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    private static void clearTerminalWindows() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private static void clearTerminalUnix() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // this might work too, untested
        //Runtime.getRuntime().exec("clear");
    }
}
