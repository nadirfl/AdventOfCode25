package org.example;

import org.example.util.ResourceReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Day1 {

    public void runCode() {
        String puzzleInput = ResourceReader.readPuzzleInput("day1.txt");
        readRotations(puzzleInput);
    }

    private void readRotations(String puzzleInput) {
        int position = 50;
        int zeroCounter = 0;
        int lineCounter = 0;

        for (String line : puzzleInput.lines().toList()) {
            lineCounter++;
            int startPosition = position;
            boolean hasCounterZero = false;
            char rotationDirection = line.charAt(0);
            int rotationValue = Integer.parseInt(line.substring(1));

            if (rotationValue > 100 ) {
                int rotationRest = rotationValue % 100;
                zeroCounter += ((rotationValue - rotationRest) / 100)-1;
                hasCounterZero = true;
                rotationValue = rotationRest;
            }
            position += (rotationDirection == 'R') ? rotationValue : -rotationValue;
            if (position < 0) {
                position += 100;
                zeroCounter++;
                hasCounterZero = true;
            } else if (position >= 100) {
                position -= 100;
                zeroCounter++;
                hasCounterZero = true;
            }
            if (position == 0 && !hasCounterZero) {
                zeroCounter++;
            }

            System.out.println("[ " + lineCounter + "] " +
                    "Startposition: " + startPosition +
                    ", Rotation: " + line +
                    ", Neue Position: " + position +
                    ", ZeroCounter: " + zeroCounter);
        }
        System.out.println("Anzahl Nullen: " + zeroCounter);
    }
}
