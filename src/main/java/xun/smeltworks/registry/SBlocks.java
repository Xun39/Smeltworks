package xun.smeltworks.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import xun.smeltworks.Smeltworks;

import java.util.function.Supplier;

public class SBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Smeltworks.MOD_ID);

    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4.5F, 3.0F))
    );
    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)
                    .strength(4.5F, 3.0F))
    );

    public static final DeferredBlock<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 6.0F)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 6.0F)
                    .instrument(NoteBlockInstrument.XYLOPHONE).sound(SoundType.METAL).requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<Block> FERROTIDE_BLOCK = registerBlock("ferrotide_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 6.0F)
                    .instrument(NoteBlockInstrument.BANJO).sound(SoundType.METAL).requiresCorrectToolForDrops())
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
