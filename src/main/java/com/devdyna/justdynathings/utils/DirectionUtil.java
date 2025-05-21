package com.devdyna.justdynathings.utils;

import java.util.Arrays;
import java.util.Set;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class DirectionUtil {

    public static Direction[] ALL = Direction.values();

    public static Direction[] HORIZONTAL = {
            Direction.NORTH,
            Direction.SOUTH,
            Direction.EAST,
            Direction.WEST
    };

    public static int span = 18;

    public static int[][] POS = {
            { 2 * span, span }, // down
            { span, 0 }, // up
            { span, -span }, // north
            { span, span }, // south
            { 0, 0 }, // west
            { 2 * span, 0 } // east
    };

   public static Set<BlockPos> around(BlockPos p) {
        return Set.of(
                p.north(),
                p.south(),
                p.east(),
                p.west(),
                p.north().east(),
                p.north().west(),
                p.south().east(),
                p.south().west());
    };

    public static BooleanProperty[] face = {
            BlockStateProperties.DOWN,
            BlockStateProperties.UP,
            BlockStateProperties.NORTH,
            BlockStateProperties.SOUTH,
            BlockStateProperties.WEST,
            BlockStateProperties.EAST
    };

    public static BooleanProperty[] horizontal_face = {
            BlockStateProperties.NORTH,
            BlockStateProperties.SOUTH,
            BlockStateProperties.EAST,
            BlockStateProperties.WEST
    };

    public static int indexByDir(Direction d) {
        return Arrays.asList(ALL).indexOf(d);
    }

    public static Property<?> StateByDir(Direction d) {
        return StateByDir(d, face, ALL);
    }

    public static Property<?> StateByDir(Direction d, Property<?>[] p, Direction[] s) {
        return p[Arrays.asList(s).indexOf(d)];
    }

    public static Direction randomDirection(Level l, Direction[] d) {
        return d[l.random.nextInt(d.length)];
    }

    public static int indexByStateFacing(BlockState s) {
        return s.getValue(BlockStateProperties.FACING).get3DDataValue();
    }
}
