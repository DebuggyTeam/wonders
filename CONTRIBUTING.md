# Contributing
Thanks for taking the time to contribute to Wonders. This guide will explain what is generally expected when you make a
contribution to Wonders.

## Code Quality
Code should be easy to read and understand.

### Documenting Code
```java
    ...
    public class Wonders implements ModInitializer {
    /*
        This logger is used to write text to the console and the log file.
        It is considered best practice to use your mod name as the logger's name.
        That way, it's clear which mod wrote info, warnings, and errors.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger("Wonders");
    private static final String MOD_ID = "wonders";
    
    public static Identifier ID(String path) {
        return new Identifier(MOD_ID, path);
    }
    
    @Override
    public void onInitialize(ModContainer mod) {
        // Initializes and runs code in the "WondersItems.java" file on Minecraft startup
        WondersItems.Init();
        LOGGER.info("Everything loaded from: {}!", mod.metadata().name());
    }
}
```
This section of code is made readable and understandable via clean formatting and the use of comments.

### Formatting Code
Please do not format your code like the following:
```java
public class Example {
    public static void ExampleFunction(int x, int y) {
        return x+y;
    }
    public static void main(String args[]) {
        int x=1;
        ExampleFunction(x, 100);
    }
}
```

Instead, format it as shown below:
```java
public class Example {
    public static void ExampleFunction(int x, int y) {
        return x + y;
    }
    public static void main(String args[]) {
        int x = 1;
        ExampleFunction(x, 100);
    }
}
```

```java
import java.util.ArrayList;

public class Example {
    public static void main(String args[]) {
        int x = 1;
        float y = 3.1415;
        double z = 1.00;
        String y = "This is good variable formatting";
    }
}
```