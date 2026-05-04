package com.devdyna.justdynathings.common.recipes.anvils.eclipsealloy;

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
public class RepairEclipseAlloyAnvilRecipe extends BaseAnvilRecipe<FluidFuelInput> {

    private final SizedFluidIngredient input;

    public RepairEclipseAlloyAnvilRecipe(SizedFluidIngredient input, int durability) {
        super(durability);
        this.input = input;
    }

    public static RepairEclipseAlloyAnvilRecipe of(SizedFluidIngredient input, int durability) {
        return new RepairEclipseAlloyAnvilRecipe(input, durability);
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
        return zRecipeTypes.ECLIPSEALLOY_ANVIL.getType();
    }

    @Override
    public RecipeSerializer<? extends Recipe<FluidFuelInput>> getSerializer() {
        return zRecipeTypes.ECLIPSEALLOY_ANVIL.getSerializer();
    }

    @Override
    public String group() {
        return Constants.Anvils.t4;
    }

    @Override
    public Item getToastIcon() {
        return zBlocks.ECLIPSEALLOY_ANVIL.get().asItem();
    }

    public static final RecipeSerializer<RepairEclipseAlloyAnvilRecipe> serializer() {
        return new RecipeSerializer<>(CODEC, STREAM_CODEC);
    }

    public static final MapCodec<RepairEclipseAlloyAnvilRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            SizedFluidIngredient.CODEC.fieldOf("fluid_ingredient").forGetter(RepairEclipseAlloyAnvilRecipe::getInput),
            Codec.intRange(1, Integer.MAX_VALUE).fieldOf("durability")
                    .forGetter(RepairEclipseAlloyAnvilRecipe::getDurability))
            .apply(inst, RepairEclipseAlloyAnvilRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, RepairEclipseAlloyAnvilRecipe> STREAM_CODEC = StreamCodec
            .composite(
                    SizedFluidIngredient.STREAM_CODEC, RepairEclipseAlloyAnvilRecipe::getInput,
                    ByteBufCodecs.INT, RepairEclipseAlloyAnvilRecipe::getDurability,
                    RepairEclipseAlloyAnvilRecipe::new);

}