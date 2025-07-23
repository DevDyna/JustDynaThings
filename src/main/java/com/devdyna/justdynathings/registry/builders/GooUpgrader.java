package com.devdyna.justdynathings.registry.builders;

import java.util.ArrayList;
import com.devdyna.justdynathings.registry.types.zProperties;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")
public class GooUpgrader extends Item {

    private ArrayList<Block> fromBlocks;
    private ArrayList<Block> toBlocks;
    private boolean makeAllasOne;

    public GooUpgrader(ArrayList<Block> fromBlocks, ArrayList<Block> toBlocks, boolean makeAllasOne) {
        super(zProperties.iProp);
        this.fromBlocks = fromBlocks;
        this.toBlocks = toBlocks;
        this.makeAllasOne = makeAllasOne;
    }

    @Override
    public InteractionResult useOn(UseOnContext c) {
        var pos = c.getClickedPos();
        var level = c.getLevel();
        var state = level.getBlockState(pos);

        if (fromBlocks.contains(state.getBlock())) {
            level.setBlockAndUpdate(pos,
                    (makeAllasOne ? toBlocks.get(0) : toBlocks.get(fromBlocks.indexOf(state.getBlock())))
                            .defaultBlockState());
            c.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        } else

            return super.useOn(c);
    }

}
