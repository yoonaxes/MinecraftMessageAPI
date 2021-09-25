package net.yoonaxes.message;

import net.yoonaxes.translator.ColorTranslator;
import net.yoonaxes.translator.impl.DefaultColorTranslator;
import org.bukkit.plugin.Plugin;

/**
 * An open source Bukkit API for comfortable creating and sending messages with your own variables.
 * Fully modified and intended for large projects.
 * @author yoonaxes
 */
public final class MinecraftMessageAPI {

    public static MinecraftMessageAPI INSTANCE;

    private Plugin plugin;

    private ColorTranslator translator;

    /**
     * Create a new instance
     */
    public MinecraftMessageAPI() {
        INSTANCE = this;
    }

    /**
     * Register this API in your Plugin.
     * @param plugin Plugin that uses the API
     */
    public void register(Plugin plugin) {
        this.plugin = plugin;

        if(this.translator == null)
            this.translator = DefaultColorTranslator.DEFAULT_COLOR_TRANSLATOR;
    }

    /**
     * Select a ColorTranslator method.
     * @param translator ColorTranslator
     * @return MinecraftMessageAPI
     */
    public MinecraftMessageAPI withTranslator(ColorTranslator translator) {
        this.translator = translator;
        return this;
    }

    /**
     * Get a registerd Plugin method.
     * @return Registred Plugin
     */
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Get a ColorTranslator method.
     * @return Selected ColorTranslator
     */
    public ColorTranslator getTranslator() {
        return translator;
    }

    /**
     * Get a ColorTranslator static method.
     * @return Selected ColorTranslator
     */
    public static ColorTranslator getColorTranslator() {
        return INSTANCE == null
                ? DefaultColorTranslator.DEFAULT_COLOR_TRANSLATOR
                : INSTANCE.getTranslator();
    }
}
