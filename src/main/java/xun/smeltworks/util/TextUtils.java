package xun.smeltworks.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import xun.smeltworks.Smeltworks;

public class TextUtils {

    public static String getId(String... suffixes) {
        return Smeltworks.MOD_ID + ":" + String.join("_", suffixes);
    }

    public static MutableComponent addTranslation(String type, String key) {
        return Component.translatable(type + '.' + Smeltworks.MOD_ID + '.' + key);
    }
}
