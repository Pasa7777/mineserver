package net.minecraft.world.level.levelgen.feature.rootplacers;

import com.mojang.serialization.Codec;
import net.minecraft.core.IRegistry;
import net.minecraft.core.registries.BuiltInRegistries;

public class RootPlacerType<P extends RootPlacer> {

    public static final RootPlacerType<MangroveRootPlacer> MANGROVE_ROOT_PLACER = register("mangrove_root_placer", MangroveRootPlacer.CODEC);
    private final Codec<P> codec;

    private static <P extends RootPlacer> RootPlacerType<P> register(String s, Codec<P> codec) {
        return (RootPlacerType) IRegistry.register(BuiltInRegistries.ROOT_PLACER_TYPE, s, new RootPlacerType<>(codec));
    }

    private RootPlacerType(Codec<P> codec) {
        this.codec = codec;
    }

    public Codec<P> codec() {
        return this.codec;
    }
}
