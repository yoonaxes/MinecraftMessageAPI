package net.yoonaxes.message.builders;

import net.yoonaxes.message.MinecraftMessageAPI;
import net.yoonaxes.message.variable.MessageVariable;
import net.yoonaxes.message.variable.VariableUtil;
import org.bukkit.command.CommandSender;

/**
 * MessageBuilder allows you to quickly and conveniently create and send messages with custom variables.
 * @author yoonaxes
 */
public class MessageBuilder {

    private String[] messages;

    public MessageBuilder(String... messages) {
        this.messages = messages;
    }

    public String[] getMessages() {
        return messages;
    }

    public MessageBuilder withTranslator() {
        this.messages = MinecraftMessageAPI.getColorTranslator().translateArray(messages);
        return this;
    }

    public MessageBuilder withVariable(MessageVariable variable) {
        return this.withVariable(null, variable);
    }

    public MessageBuilder withVariable(String prefix, MessageVariable variable) {
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

    public MessageBuilder withVariable(String variable, String replacement) {
        return this.withVariable(null, variable, replacement);
    }

    public MessageBuilder withVariable(String prefix, String variable, String replacement) {
        for(int i = 0; i < messages.length; ++i) {
            messages[i] = messages[i].replace(
                    VariableUtil.getVariableString(prefix, variable),
                    replacement
            );
        }
        return this;
    }

    public void send(CommandSender commandSender) {
        for(String message : messages)
            commandSender.sendMessage(message);
    }

    public static MessageBuilder create(String message) {
        return new MessageBuilder(message);
    }
}
