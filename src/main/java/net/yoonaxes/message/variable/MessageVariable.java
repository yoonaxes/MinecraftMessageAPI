package net.yoonaxes.message.variable;

import java.util.HashMap;

public interface MessageVariable {

    default String getName() {
        return this.getClass().getSimpleName()
                .replace("Message", "")
                .replace("Variable", "")
                .toUpperCase();
    }

    /**
     * Get an replacement map for variable.
     * @return Replacement HashMap<String, String>
     */
    HashMap<String, String> getReplacementMap();
}
