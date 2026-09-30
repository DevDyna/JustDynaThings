package com.devdyna.justdynathings.api;

import java.util.*;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

//TODO API : move to api replacing DirectionUtil
public class DirUtils {

    public static class Directions {
        public final static Direction[] ALL = Direction.values();

        public final static Direction[] HORIZONTAL = {
                Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST
        };

        public final static Direction[] VERTICAL = {
                Direction.UP,
                Direction.DOWN
        };

    }

    public static class DirProperties {
        public final static BooleanProperty[] ALL = {
                BlockStateProperties.DOWN,
                BlockStateProperties.UP,
                BlockStateProperties.NORTH,
                BlockStateProperties.SOUTH,
                BlockStateProperties.WEST,
                BlockStateProperties.EAST
        };

        public final static BooleanProperty[] HORIZONTAL = {
                BlockStateProperties.NORTH,
                BlockStateProperties.SOUTH,
                BlockStateProperties.EAST,
                BlockStateProperties.WEST
        };

        public final static BooleanProperty[] VERTICAL = {
                BlockStateProperties.UP,
                BlockStateProperties.DOWN
        };

    }

    public static ArrayList<BlockPos> getAround(BlockPos p) {
        return getAround(p, true);
    }

    public static ArrayList<BlockPos> getAround(BlockPos p, boolean diagonals) {

        var base = new ArrayList<>(List.of(p.north(),
                p.south(),
                p.east(),
                p.west()));

        if (diagonals) {
            base.add(p.north().east());
            base.add(p.north().west());
            base.add(p.south().east());
            base.add(p.south().west());
        }

        return base;
    };

    public static BooleanProperty getPropByDir(Direction d) {
        return getPropByDir(d, DirProperties.ALL, Directions.ALL);
    }

    public static <P extends Property<?>> P getPropByDir(Direction d, P[] p, Direction... s) {
        return p[Arrays.asList(s).indexOf(d)];
    }

    public static Direction getRandomDir(Level l, Direction... d) {
        return d[l.getRandom().nextInt(d.length)];
    }

    public static Direction getRandomDir(Level l) {
        return getRandomDir(l, Directions.ALL);
    }

}