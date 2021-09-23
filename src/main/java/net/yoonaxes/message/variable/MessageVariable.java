package net.yoonaxes.message.variable;

import java.util.HashMap;

public interface MessageVariable {

    default String getName() {
        return this.getClass().getSimpleName()
                .replace("Message", "")
                .replace("Variable", "")
                .toUpperCase();
    }

    HashMap<String, String> getReplacementMap();
}
