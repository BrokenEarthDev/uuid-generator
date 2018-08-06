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

import java.util.UUID;

/**
 * This class handles the generation of String, Long, and Integer -
 * and even {@link UUID}
 * You can generate any String with a given character count or a given maximum and minimum
 * character count.
 * Refer to {@link GeneratorBuilder}
 * <br>For example
 * <pre>
 *     Generator generator = new GeneratorBuilder()
 *                  // sets the character count
 *                 .setCharacterCount((byte) 12)
 *                 // sets the separator (-) difference between every specified characters
 *                 .setSeparatorDifference((byte) 5)
 *                 // returns the Generator
 *                 .build();
 *     String generated = generator.generate();
 * </pre>
 * For the implementation, see {@link GeneratorImpl}.
 */
public interface Generator {
    /**
     * Generates a random string with a specified character count
     * (or a specified minimum and maximum character count)
     *
     * @return The generated random string
     */
    String generate();
    /**
     * Generates a random {@link Long} with a specified character count
     * (or a specified minimum and maximum character count)
     * Make sure to not specify a character count (or a maximum character count)
     * greater than 19.
     *
     * @return The generated random long
     */
    long generateLong();
    /**
     * Generates a random {@link Integer} with a specified character count
     * (or a specified minimum and maximum character count)
     * Make sure to not specify a character count (or a maximum character count)
     * greater than 10.
     *
     * @return The generated random integer
     */
    int generateInt();

    /**
     * Generates a random {@link UUID}. Note that this option will not be affected by character count,
     * or any other options from the {@link GeneratorBuilder}
     * because it uses
     * <pre>
     *  UUID.randomUUID()
     * </pre>
     *
     * @return The generated uuid
     */
    UUID generateUUID();

}
