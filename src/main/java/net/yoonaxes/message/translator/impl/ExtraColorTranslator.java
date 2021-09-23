package net.yoonaxes.message.translator.impl;

import net.yoonaxes.message.translator.ColorTranslator;

/**
 * Extra color translator to bukkit translate alternate codes.
 * Its additional advantage is the changeable characters specially.
 * @author yoonaxes
 */
public class ExtraColorTranslator implements ColorTranslator {

    @Override
    public String translateString(String string) {
        return ColorTranslator.super.translateString(
                string
                        .replace("{*}", "\u00B7")       /* · */
                        .replace("{>}", "\u00BB")       /* » */
                        .replace("{<}", "\u00AB")       /* « */
                        .replace("{->}", "\u2192")      /* → */
                        .replace("{<-}", "\u2190")      /* ← */
        );
    }
}
