/*
Copyright 2018 github.com/BrokenEarthDev // gitlab.com/BrokenEarth

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
 */
package me.brokenearthdev.uuidgenerator.impl;

import me.brokenearthdev.uuidgenerator.Generator;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is an implementation of {@link Generator}.
 * This class handles the generation. For more information, take a look at
 * {@link Generator}
 */
public final class GeneratorImpl implements Generator {
    /**
     * The maximum character count
     */
    private byte max;
    /**
     * The minimum character count
     */
    private byte min;
    /**
     * Specifies whether the separator (-) should be
     * included or not
     */
    private boolean includeSeparator;
    /**
     * Specifies whether the letters should be
     * included or not
     */
    private boolean includeLetters;
    /**
     * Specifies whether the cased letters should be
     * included or not. If set to false, letters will be only
     * lower cased
     */
    private boolean includeCasedLetters;
    /**
     * The separator (-) will be inserted every specified character count
     * if includeSeparator is true
     */
    private byte separatorDifference;
    /**
     * @param max The maximum character count
     * @param min The minimum character count
     * @param separatorDifference The separator (-) will be inserted every specified character count
     *                            if includeSeparator is true
     * @param includeSeparator Specifies whether the separator (-) should be
     *                         included or not
     * @param includeLetters Specifies whether the letters should be
     *                       included or not
     * @param includeCasedLetters Specifies whether the cased letters should be
     *                            included or not. If set to false, letters will be only
     *                            lower cased
     */
    public GeneratorImpl(byte max, byte min, byte separatorDifference, boolean includeSeparator, boolean includeLetters, boolean includeCasedLetters) {
        this.max = max;
        this.min = min;
        this.includeSeparator = includeSeparator;
        this.includeLetters = includeLetters;
        this.includeCasedLetters = includeCasedLetters;
        this.separatorDifference = separatorDifference;
    }

    @Override
    public String generate() {
        byte count = (byte) generateNumber(max, min);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int random = new Random().nextInt(2);
            boolean shouldUseNumbers = !includeLetters || random == 0;
            if (shouldUseNumbers) builder.append(generateNumber());
            else builder.append((includeCasedLetters) ? generateLetterIncludingCases() : generateLetter());
        }
        String result = builder.toString();
        if (includeSeparator) {
            try {
                return addSeparator(result, separatorDifference);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else return result;
        return null;
    }

    @Override
    public long generateLong() {
        int max = generateNumber(this.max, min);
        String combined = "";
        if (max == 19) {
            return ThreadLocalRandom.current().nextLong((9223372036854775807L - 1000000000000000000L) + 1) + 1000000000000000001L;
        } else if (max >= 20) {
            throw new NumberFormatException("Specified value is greater than long's range");
        } else {
            int current = 0;
            for (int i = 0; i < max; i++) {
                Random rand = new Random();
                int random = rand.nextInt(10);
                combined += random;
            }
        }
        return Long.parseLong(combined);
    }
    @Override
    public int generateInt() {
        int max = generateNumber(this.max, min);
        String combined = "";
        if (max == 10) {
            return new Random().nextInt((2147483647 - 1000000000) + 1) + 1000000000;
        } else if (max > 10) {
            throw new NumberFormatException("Specified value is greater than interger's range");
        } else {
            for (int i = 0; i < max; i++) {
                Random random = new Random();
                int generated = random.nextInt(10);
                combined += generated;
            }
        }
        return Integer.parseInt(combined);
    }
    @Override
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
    /**
     * Generates a random letter using {@link Random}
     * The generated letter will be lower cased
     *
     * @return The random generated letter
     */
    private static char generateLetter() {
        int random = new Random().nextInt(26);
        if (random == 0) return 'a';
        else if (random == 1) return 'b';
        else if (random == 2) return 'c';
        else if (random == 3) return 'd';
        else if (random == 4) return 'e';
        else if (random == 5) return 'f';
        else if (random == 6) return 'g';
        else if (random == 7) return 'h';
        else if (random == 8) return 'i';
        else if (random == 9) return 'j';
        else if (random == 10) return 'k';
        else if (random == 11) return 'l';
        else if (random == 12) return 'm';
        else if (random == 13) return 'n';
        else if (random == 14) return 'o';
        else if (random == 15) return 'p';
        else if (random == 16) return 'q';
        else if (random == 17) return 'r';
        else if (random == 18) return 's';
        else if (random == 19) return 't';
        else if (random == 20) return 'u';
        else if (random == 21) return 'v';
        else if (random == 22) return 'w';
        else if (random == 23) return 'x';
        else if (random == 24) return 'y';
        else if (random == 25) return 'z';
        return '\0';
    }

    /**
     * Generates a random cased letter. The generated letter
     * could be either upper cased or lower cased
     *
     * @return The random generated letter
     */
    private static char generateLetterIncludingCases() {
        boolean caps = new Random().nextInt(2) != 0;
        char rand = generateLetter();
        if (rand == 0) return '\0';
        return (caps) ? Character.toUpperCase(rand) : rand;
    }
    /**
     * Adds a separator into a specified string with the separator difference specified.
     * The separator difference is the amount of characters before a separator (-) will be
     * placed
     *
     * @param rand The string that the separator would be inserted in
     * @param separatorDifference The separator difference - amount of characters before a
     *                            separator (-) is placed
     * @return The specified string with a separator(s) (-) placed
     */
    private static String addSeparator(String rand, int separatorDifference) {
        separatorDifference++;
        char chars[] = rand.toCharArray();
        StringBuilder builder = new StringBuilder();
        int inDifference = 0;
        for (char character : chars) {
            inDifference++;
            if (inDifference == separatorDifference) {
                builder.append("-");
                inDifference = 0;
            }
            builder.append(character);
        }
        return builder.toString();
    }
    /**
     * Checks if the number is even by using the modulus operator
     *
     * @param number The number to check if it is even or not
     * @return Whether the number is even or not
     */
    private static boolean isEven(int number){
        return (number % 2) == 0;
    }
    /**
     * Generates a random number with the given maximum and the given
     * minimum.
     *
     * @param max The maximum number where the number generator would generate
     * @param min The minimum number where the number generator would generate
     * @return The random generated number
     */
    private static int generateNumber(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    /**
     * Generates a random number 0 through 9
     *
     * @return the random generated number
     */
    private static int generateNumber() {
        return generateNumber(9, 0);
    }
}
