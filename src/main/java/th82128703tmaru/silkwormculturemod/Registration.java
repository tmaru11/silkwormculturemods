package th82128703tmaru.silkwormculturemod;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import th82128703tmaru.silkwormculturemod.item.FoodItem;

public class Registration {private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "silkwormculturemod");
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "silkwormculturemod");
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);}public static final BlockBehaviour.Properties BLOCK_PROPERTIES = BlockBehaviour.Properties.of(Material.GRASS).strength(1f).sound(SoundType.GRASS).requiresCorrectToolForDrops().destroyTime(0f).noCollission().noOcclusion();
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.TAB);public static final RegistryObject<Block>
            TESTBLOCK = BLOCKS.register("testblock", () -> new CustomPlantBlock(BLOCK_PROPERTIES));
    public static final RegistryObject<Item> TESTBLOCK_ITEM = fromBlock(TESTBLOCK, ITEM_PROPERTIES.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build()))););

    public static final BlockBehaviour.Properties BLOCK_PROPERTIES2 = BlockBehaviour.Properties.of(Material.GRASS).strength(2f).sound(SoundType.GRASS).destroyTime(1f).noOcclusion().requiresCorrectToolForDrops();
    public static final RegistryObject<Block> TESTBLOCK2 = BLOCKS.register("testblock2_id", () -> new Block(BLOCK_PROPERTIES2));

    public static final RegistryObject<Item> TESTBLOCK2_ITEM = fromBlock(TESTBLOCK2,ITEM_PROPERTIES);
    public static final BlockBehaviour.Properties BLOCK_PROPERTIES3 = BlockBehaviour.Properties.of(Material.METAL).strength(3f).sound(SoundType.METAL).destroyTime(3f).noOcclusion().requiresCorrectToolForDrops();
    public static final RegistryObject<Block> TESTBLOCK3 = BLOCKS.register("testblock3", () -> new Block(BLOCK_PROPERTIES3));

    public static final RegistryObject<Item> TESTBLOCK3_ITEM = fromBlock(TESTBLOCK3,ITEM_PROPERTIES);

    public static final RegistryObject<Item> TESTFOOD = ITEMS.register("testfood", () -> new FoodItem(ITEM_PROPERTIES.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build())));


    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties prop) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), prop));

    }}
