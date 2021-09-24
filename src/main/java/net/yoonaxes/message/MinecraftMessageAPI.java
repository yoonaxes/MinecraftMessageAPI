package net.yoonaxes.message;

import net.yoonaxes.translator.ColorTranslator;
import net.yoonaxes.translator.impl.DefaultColorTranslator;
import org.bukkit.plugin.Plugin;

public final class MinecraftMessageAPI {

    public static MinecraftMessageAPI INSTANCE;

    private Plugin plugin;

    private ColorTranslator translator;

    public MinecraftMessageAPI() {
        INSTANCE = this;
    }

    public void register(Plugin plugin) {
        this.plugin = plugin;

        if(this.translator == null)
            this.translator = DefaultColorTranslator.DEFAULT_COLOR_TRANSLATOR;
    }

    public MinecraftMessageAPI withTranslator(ColorTranslator translator) {
        this.translator = translator;
        return this;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public ColorTranslator getTranslator() {
        return translator;
    }

    public static ColorTranslator getColorTranslator() {
        return INSTANCE == null
                ? DefaultColorTranslator.DEFAULT_COLOR_TRANSLATOR
                : INSTANCE.getTranslator();
    }
}
