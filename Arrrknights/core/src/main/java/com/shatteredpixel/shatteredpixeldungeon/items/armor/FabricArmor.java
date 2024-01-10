package com.shatteredpixel.shatteredpixeldungeon.items.armor;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class FabricArmor extends Armor {
    {
        image = ItemSpriteSheet.ARMOR_FABRIC;
        bones = false;
    }

    public FabricArmor() {
        super(1);
    }
}
