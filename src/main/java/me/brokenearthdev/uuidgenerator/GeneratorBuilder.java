/*
Copyright 2018 github.com/BrokenEarthDev // gitlab.com/BrokenEarth

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
 */
package me.brokenearthdev.uuidgenerator;

import me.brokenearthdev.uuidgenerator.impl.GeneratorImpl;

/**
 * This class handles creating (building) the {@link Generator}.
 * You can use this class, for example:
 * <pre>
 *     Generator generator = new GeneratorBuilder()
 *                    // sets the character count
 *                   .setCharacterCount((byte) 12)
 *                   // sets the separator (-) difference between every specified characters
 *                   .setSeparatorDifference((byte) 5)
 *                   // returns the Generator
 *                   .build();
 *     String generated = generator.generate();
 * </pre>
 */
public final class GeneratorBuilder {
    /**
     * Specifies whether the generator should include letters or not.
     * By default, the generator will include letters
     */
    private boolean includeLetters = true;
    /**
     * Specifies whether the generator should include cased letters (uppercase and lowercase letters)
     * or not.
     * By default, the generator will include cased letters
     */
    private boolean includeCasedLetters = true;
    /**
     * Specifies whether the generator should include separator(s) (-)
     * or not
     */
    private boolean includeSeparator = false;
    /**
     * The separator difference is the amount of characters before separator(s) (-)
     * will be placed after the recent separator. If there is not recent separator, the
     * separator will be placed after the separator difference.
     * If separatorDiffer is set to less than 0, a separator won't be placed
     */
    private byte separatorDifference = -1;
    /**
     * The maximum character count
     */
    private byte max = 8;
    /**
     * The minimum character count
     */
    private byte min = 8;

    /**
     * Sets whether the generator include letters or not. By default, letters
     * are included
     *
     * @param include Whether the generator include letters or not.
     * @return This class
     */
    public GeneratorBuilder setIncludeLetters(boolean include) {
        includeLetters = include;
        includeCasedLetters = include && includeCasedLetters;
        return this;
    }
    /**
     * Sets whether the generator include cased letters or not. By default, cased letters
     * are included
     *
     * @param include Whether the generator include cased letters or not
     * @return This class
     */
    public GeneratorBuilder setIncludeCasedLetters(boolean include) {
        includeLetters = include || includeLetters;
        includeCasedLetters = include;
        return this;
    }
    /**
     * Sets whether the generator include the separator (-) or not. By default,
     * separators aren't included
     *
     * @param include Whether the generator include the separator or not
     * @return This class
     */
    public GeneratorBuilder setIncludeSeparator(boolean include) {
        includeSeparator = include;
        separatorDifference = (separatorDifference == -1) ? 1 : separatorDifference;
        return this;
    }
    /**
     * Sets the separator difference. By default, separator aren't included
     *
     * @param difference The separator difference. If the difference is less than 1,
     *                   the separator would not be included
     * @return This class
     */
    public GeneratorBuilder setSeparatorDifference(byte difference) {
        this.separatorDifference = (difference != 0) ? difference : -1;
        this.includeSeparator = difference > 0;
        return this;
    }
    /**
     * Sets the character count. By default, the character count is set
     * to 8
     *
     * @param count The character count
     * @return This class
     */
    public GeneratorBuilder setCharacterCount(byte count) {
        max = count;
        min = count;
        return this;
    }
    /**
     * Sets the minimum character count. By default, the minimum character count
     * is set to 8
     *
     * @param count The minimum character count
     * @return This class
     */
    public GeneratorBuilder setMinimumCharacterCount(byte count) {
        min = count;
        return this;
    }
    /**
     * Sets the maximum character count. By default, the maximum character count
     * is set to 8
     *
     * @param count The maximum character count
     * @return This class
     */
    public GeneratorBuilder setMaximumCharacterCount(byte count) {
        max = count;
        return this;
    }
    /**
     * Creates a {@link Generator} implementation class instance ({@link GeneratorImpl})
     *
     * @return The {@link GeneratorImpl} instance
     */
    public Generator build() {
        return new GeneratorImpl(max, min, separatorDifference, includeSeparator, includeLetters, includeCasedLetters);
    }

}
