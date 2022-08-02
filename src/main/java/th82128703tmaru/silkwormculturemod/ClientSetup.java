package th82128703tmaru.silkwormculturemod;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "silkwormculturemod", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ClientSetup {public static void init(FMLClientSetupEvent event)
{
    ItemBlockRenderTypes.setRenderLayer(Registration.TESTBLOCK.get(), RenderType.translucent());
}
}


