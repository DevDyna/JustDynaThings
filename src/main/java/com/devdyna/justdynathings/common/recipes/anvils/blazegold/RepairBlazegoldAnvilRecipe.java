package com.devdyna.justdynathings.common.recipes.anvils.blazegold;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.inputs.FluidFuelInput;
import com.devdyna.justdynathings.api.repair_anvils.BaseAnvilRecipe;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

@SuppressWarnings("null")
public class RepairBlazegoldAnvilRecipe extends BaseAnvilRecipe<FluidFuelInput> {

    private final SizedFluidIngredient input;

    public RepairBlazegoldAnvilRecipe(SizedFluidIngredient input, int durability) {
        super(durability);
        this.input = input;
    }

    public static RepairBlazegoldAnvilRecipe of(SizedFluidIngredient input, int durability) {
        return new RepairBlazegoldAnvilRecipe(input, durability);
    }

    public boolean matches(FluidFuelInput r, Level l) {
        return this.input.test(r.input());
    }

    @Deprecated
    @Override
    public ItemStack assemble(FluidFuelInput r) {
        return ItemStack.EMPTY;
    }

    public SizedFluidIngredient getInput() {
        return input;
    }

    @Override
    public RecipeType<? extends Recipe<FluidFuelInput>> getType() {
        return zRecipeTypes.BLAZEGOLD_ANVIL.getType();
    }

    @Override
    public RecipeSerializer<? extends Recipe<FluidFuelInput>> getSerializer() {
        return zRecipeTypes.BLAZEGOLD_ANVIL.getSerializer();
    }

    @Override
    public String group() {
        return Constants.Anvils.t2;
    }

    @Override
    public Item getToastIcon() {
        return zBlocks.BLAZEGOLD_ANVIL.get().asItem();
    }

    public static final RecipeSerializer<RepairBlazegoldAnvilRecipe> serializer() {
        return new RecipeSerializer<>(CODEC, STREAM_CODEC);
    }

    public static final MapCodec<RepairBlazegoldAnvilRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            SizedFluidIngredient.CODEC.fieldOf("fluid_ingredient").forGetter(RepairBlazegoldAnvilRecipe::getInput),
            Codec.intRange(1, Integer.MAX_VALUE).fieldOf("durability")
                    .forGetter(RepairBlazegoldAnvilRecipe::getDurability))
            .apply(inst, RepairBlazegoldAnvilRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, RepairBlazegoldAnvilRecipe> STREAM_CODEC = StreamCodec
            .composite(
                    SizedFluidIngredient.STREAM_CODEC, RepairBlazegoldAnvilRecipe::getInput,
                    ByteBufCodecs.INT, RepairBlazegoldAnvilRecipe::getDurability,
                    RepairBlazegoldAnvilRecipe::new);

}