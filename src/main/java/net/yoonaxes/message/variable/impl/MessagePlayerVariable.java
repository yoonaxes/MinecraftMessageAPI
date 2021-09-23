package net.yoonaxes.message.variable.impl;

import net.yoonaxes.message.variable.MessageObjectVariable;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessagePlayerVariable implements MessageObjectVariable<Player> {

    private final Player player;

    public MessagePlayerVariable(Player player) {
        this.player = player;
    }

    @Override
    public Player getVariableObject() {
        return player;
    }

    @Override
    public HashMap<String, String> getReplacementMap() {
        Player player = this.getVariableObject();
        HashMap<String, String> map = new HashMap<>();

        String uniqueId = player.getUniqueId().toString();
        map.put("uuid", uniqueId);
        map.put("uniqueId", uniqueId);

        map.put("name", player.getName());
        map.put("display_name", player.getDisplayName());
        map.put("custom_name", player.getCustomName() == null
                ? player.getName()
                : player.getCustomName()
        );

        return map;
    }
}
