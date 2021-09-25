package net.yoonaxes.message;

import net.yoonaxes.message.builders.MessageBuilder;

/**
 * MB is class with method to create MessageBuilder instance.
 * MessageBuilder allows you to quickly and conveniently create and send messages with custom variables.
 * @author yoonaxes
 */
public final class MB {

    /**
     * Create a new instance.
     * @param messages Messages in array
     * @return new MessageBuilder
     */
    public static MessageBuilder create(String... messages) {
        return MessageBuilder.create(messages);
    }
}
