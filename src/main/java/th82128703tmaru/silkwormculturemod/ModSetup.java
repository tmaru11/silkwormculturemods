package th82128703tmaru.silkwormculturemod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "silkwormculturemod", bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModSetup {public static final CreativeModeTab TAB = new CreativeModeTab("silkworm") {
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.GOLD_INGOT);
    }
};
}
