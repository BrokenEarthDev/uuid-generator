# What is the UUID Generator? 
The uuid generator is not only a uuid generator. The uuid generator generates a random String, Integer, Long, and UUID with a specified character count and other settings.
## How can I get it?
To get it, go to the <a href="https://github.com/BrokenEarthDev/uuid-generator/releases/tag/v1.0">releases section in github</a>
# Using the UUID Generator:
## Setting up:
```java
Generator generator = new GeneratorBuilder()
                .setCharacterCount((byte) 8)
                .setSeparatorDifference((byte) 4)
                .setIncludeCasedLetters(true)
                .build();
```

**A <a href="https://gitlab.com/BrokenEarth/uuid-generator/blob/master/src/main/java/me/brokenearthdev/uuidgenerator/Generator.java">Generator</a> is responsible for generating a random String, Integer, Long, and UUIDs.** You created a generator instance by using <a href="https://gitlab.com/BrokenEarth/uuid-generator/blob/master/src/main/java/me/brokenearthdev/uuidgenerator/GeneratorBuilder.java">GeneratorBuilder</a>

## Result
By calling **generator.generate()**, It will generate a random String and returns it.
```java
System.out.println(generator.generate());
```
Using the code above will generate a random string with a separator difference of 4 and a character count of 8.
```
494p-86O3
```

# Options:
These are the options from the **<a href="https://gitlab.com/BrokenEarth/uuid-generator/blob/master/src/main/java/me/brokenearthdev/uuidgenerator/GeneratorBuilder.java">GeneratorBuilder</a>**:

<ol>
  <li><strong>setIncludeLetters</strong>: Sets whether the letters will be included</li>
  <li><strong>setIncludeCasedLetters</strong>: Sets whether the cased letters (uppercase and lowercase letters) will be included</li>
  <li><strong>setIncludeSeparator</strong>: Sets whether the separator will be included or not</li>
  <li><strong>setSeparatorDifference</strong>: Sets the separator difference</li>
  <li><strong>setCharacterCount</strong>: Sets the character count</li>
  <li><strong>setMinimumCharacterCount</strong>: Sets the minimum character count</li>
  <li><strong>setMaximumCharacterCount</strong>: Sets the maximum character count</li>
</ol>
