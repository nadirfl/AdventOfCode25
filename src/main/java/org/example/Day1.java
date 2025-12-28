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
            char rotationDirection = line.charAt(0);
            int rotationValue = Integer.parseInt(line.substring(1));
            if (rotationValue > 100 ) {
                rotationValue = rotationValue % 100;
            }
            position += (rotationDirection == 'R') ? rotationValue : -rotationValue;
            position += (position <= 0) ? 100 : 0;
            position -= (position >= 100) ? 100 : 0;

            zeroCounter += (position == 0) ? 1 : 0;

            System.out.println("[ " + lineCounter + "] " +
                    "Startposition: " + startPosition +
                    ", Rotation: " + line +
                    ", Neue Position: " + position);
        }
        System.out.println("Anzahl Nullen: " + zeroCounter);
    }
}
