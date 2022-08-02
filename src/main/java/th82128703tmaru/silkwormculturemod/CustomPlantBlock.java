package th82128703tmaru.silkwormculturemod;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CustomPlantBlock extends SweetBerryBushBlock {public CustomPlantBlock(BlockBehaviour.Properties prop) {
    super(prop);
    this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
}
    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos position, Player
            player, InteractionHand handSide, BlockHitResult hitResult) {
        int i = blockstate.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(handSide).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            popResource(world, position, new ItemStack(Items.DIAMOND_BLOCK, j + (flag ? 1 : 0)));
            world.playSound((Player) null, position, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlock(position, blockstate.setValue(AGE, Integer.valueOf(1)), 2);
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return super.use(blockstate, world, position, player, handSide, hitResult);
        }
    }}

