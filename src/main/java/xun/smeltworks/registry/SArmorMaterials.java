package xun.smeltworks.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xun.smeltworks.Smeltworks;

import java.util.EnumMap;
import java.util.List;

public class SArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Smeltworks.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FERROTIDE = register("ferrotide",
            3, 6, 8, 3, 11, 16,
            5.0F, 0.0F,
            SoundEvents.ARMOR_EQUIP_NETHERITE, SItems.FERROTIDE_INGOT);

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name, int helmetDefense, int chestplateDefense, int leggingsDefense, int bootsDefense, int bodyDefense, int enchantmentValue,
            float armorToughness, float knockbackResistance,
            Holder<SoundEvent> equipSound, ItemLike repairIngredient) {

        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, helmetDefense);
            map.put(ArmorItem.Type.CHESTPLATE, chestplateDefense);
            map.put(ArmorItem.Type.LEGGINGS, leggingsDefense);
            map.put(ArmorItem.Type.BOOTS, bootsDefense);
            map.put(ArmorItem.Type.BODY, bodyDefense);

        }), enchantmentValue, equipSound, () -> Ingredient.of(repairIngredient),
                List.of(new ArmorMaterial.Layer(Smeltworks.modLoc(name))), armorToughness, knockbackResistance));
    }
}
