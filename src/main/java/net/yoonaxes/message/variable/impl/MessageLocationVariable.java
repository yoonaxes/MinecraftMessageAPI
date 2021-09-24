package net.yoonaxes.message.variable.impl;

import net.yoonaxes.message.variable.MessageObjectVariable;
import net.yoonaxes.message.variable.VariableUtil;
import org.bukkit.Location;

import java.util.HashMap;

public class MessageLocationVariable implements MessageObjectVariable<Location> {

    private final Location location;

    public MessageLocationVariable(Location location) {
        this.location = location;
    }

    @Override
    public Location getVariableObject() {
        return location;
    }

    @Override
    public HashMap<String, String> getReplacementMap() {
        HashMap<String, String> map = new HashMap<>();

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        String locationString = (int) x + " " + (int) y + " " + (int) z;

        map.put("loc", locationString);
        map.put("location", locationString);

        map.put("x", String.valueOf((int) x));
        map.put("y", String.valueOf((int) y));
        map.put("z", String.valueOf((int) z));

        map.put("xx", VariableUtil.DOUBLE_FORMAT.format(x));
        map.put("yy", VariableUtil.DOUBLE_FORMAT.format(y));
        map.put("zz", VariableUtil.DOUBLE_FORMAT.format(z));

        map.put("world",
                location.getWorld() == null
                        ? "world"
                        : location.getWorld().getName()
        );

        return map;
    }
}
