package cc.funkemunky.api.utils.blockbox.impl;

import cc.funkemunky.api.utils.BoundingBox;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material ;
import org.bukkit.block.Block;

@Getter
@Setter
public abstract class BlockBox {
    private Material material;
    private BoundingBox original;

    BlockBox(Material material, BoundingBox original) {
        this.material = material;
        this.original = original;
    }

    abstract BoundingBox getBox(Block block);
}
