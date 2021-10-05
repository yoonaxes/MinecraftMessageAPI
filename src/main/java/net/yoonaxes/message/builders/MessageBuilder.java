package net.yoonaxes.message.builders;

import net.yoonaxes.message.MinecraftMessageAPI;
import net.yoonaxes.message.variable.MessageVariable;
import net.yoonaxes.message.variable.VariableUtil;
import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.List;

/**
 * MessageBuilder allows you to quickly and conveniently create and send messages with custom variables.
 * @author yoonaxes
 */
public class MessageBuilder {

    private String[] messages;

    /**
     * Create an instance.
     * @param messages Messages in array
     */
    public MessageBuilder(String... messages) {
        this.messages = messages;
    }

    /**
     * Get messages array.
     * @return Messages Array
     */
    public String[] getMessages() {
        return messages;
    }

    /**
     * Translate message using ColorTranslatorAPI.
     * @return MessageBuilder
     */
    public MessageBuilder translate() {
        this.messages = MinecraftMessageAPI.getColorTranslator().translateArray(messages);
        return this;
    }

    /**
     * Add variable to message.
     * @param variable MessageVariable
     * @return MessageBuilder
     */
    public MessageBuilder withCustomVariable(MessageVariable variable) {
        return this.withCustomVariable(null, variable);
    }

    /**
     * Add variable to message.
     * @param prefix Prefix for variable
     * @param variable MessageVariable
     * @return MessageBuilder
     */
    public MessageBuilder withCustomVariable(String prefix, MessageVariable variable) {
        variable.getReplacementMap().forEach((name, replacement) -> {
            for(int i = 0; i < messages.length; ++i) {
                messages[i] = messages[i].replace(
                        VariableUtil.getVariableString(prefix, name),
                        replacement
                );
            }
        });
        return this;
    }

    /**
     * Add variable to message.
     * @param variable Variable to replace
     * @param replacement Replacement for variable
     * @return MessageBuilder
     */
    public MessageBuilder withVariable(String variable, String replacement) {
        return this.withVariable(null, variable, replacement);
    }

    /**
     * Add variable to message.
     * @param prefix Prefix for variable
     * @param variable Variable to replace
     * @param replacement Replacement for variable
     * @return MessageBuilder
     */
    public MessageBuilder withVariable(String prefix, String variable, String replacement) {
        for(int i = 0; i < messages.length; ++i) {
            messages[i] = messages[i].replace(
                    VariableUtil.getVariableString(prefix, variable),
                    replacement
            );
        }
        return this;
    }

    /**
     * Send all messages to the target.
     * @param commandSender Target CommandSender
     */
    public void send(CommandSender commandSender) {
        commandSender.sendMessage(messages);
    }

    /**
     * Send choosen message to the target.
     * @param commandSender Target CommandSender
     * @param numbers Message numbers
     */
    public void send(CommandSender commandSender, int... numbers) {
        for(int i : numbers) {
            String message = messages[i];
            if(message != null)
                commandSender.sendMessage(message);
        }
    }

    /**
     * Send choosen message to the target list.
     * @param list Target List
     */
    public void send(List<? extends CommandSender> list) {
        list.forEach(commandSender -> commandSender.sendMessage(messages));
    }

    /**
     * Send choosen message to the target list.
     * @param list Target List
     * @param numbers Message numbers
     */
    public void send(List<? extends CommandSender> list, int... numbers) {
        list.forEach(commandSender -> {
            for(int i : numbers) {
                String message = messages[i];
                if(message != null)
                    commandSender.sendMessage(message);
            }
        });
    }

    /**
     * Send choosen message to the target collection.
     * @param collection Target Collection
     */
    public void send(Collection<? extends CommandSender> collection) {
        collection.forEach(commandSender -> commandSender.sendMessage(messages));
    }

    /**
     * Send choosen message to the target collection.
     * @param collection Target Collection
     * @param numbers Message numbers
     */
    public void send(Collection<? extends CommandSender> collection, int... numbers) {
        collection.forEach(commandSender -> {
            for(int i : numbers) {
                String message = messages[i];
                if(message != null)
                    commandSender.sendMessage(message);
            }
        });
    }

    /**
     * Create a new instance.
     * @param messages Messages in array
     * @return new MessageBuilder
     */
    public static MessageBuilder create(String... messages) {
        return new MessageBuilder(messages);
    }
}
