package com.devdyna.justdynathings.registry.builders.functional_anvils.ferricore;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.type.anvil.ferricore.FerricoreAnvilGUI;
import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBlock;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

import javax.annotation.Nullable;

public class FerricoreAnvilBlock extends CAnvilBlock {

    public FerricoreAnvilBlock() {
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new FerricoreAnvilBE(zBlockEntities.FERRICORE_ANVIL.get(), p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new FerricoreAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof FerricoreAnvilBE;
    }

    @Override
    public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
            TooltipFlag f) {
        super.appendHoverText(i, c, t, f);
        t.add(Component.translatable(Main.ID + "." + Constants.Anvils.t1));
    }

    @Override
    public boolean supportFluidContent() {
        return false;
    }

}