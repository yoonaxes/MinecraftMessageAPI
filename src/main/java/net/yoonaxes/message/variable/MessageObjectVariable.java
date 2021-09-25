package net.yoonaxes.message.variable;

public interface MessageObjectVariable<T> extends MessageVariable {

    /**
     * Get an customized object for variable.
     * @return Object for variable
     */
    T getVariableObject();

}
