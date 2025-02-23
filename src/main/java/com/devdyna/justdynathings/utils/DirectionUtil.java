package com.devdyna.justdynathings.utils;

import java.util.Arrays;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class DirectionUtil {

    public static Direction[] ALL = Direction.values();

    public static int span = 18;

    public static int[][] POS = {
            { 2 * span, span }, // down
            { span, 0 }, // up
            { span, -span }, // north
            { span, span }, // south
            { 0, 0 }, // west
            { 2 * span, 0 } // east
    };

    public static BooleanProperty[] face = {
            BlockStateProperties.DOWN,
            BlockStateProperties.UP,
            BlockStateProperties.NORTH,
            BlockStateProperties.SOUTH,
            BlockStateProperties.WEST,
            BlockStateProperties.EAST
    };

    public static int indexByDir(Direction d) {
        return Arrays.asList(ALL).indexOf(d);
    }

    public static BooleanProperty StateByDir(Direction d) {
        return face[Arrays.asList(ALL).indexOf(d)];
    }
}
