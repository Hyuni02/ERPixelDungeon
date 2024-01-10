package com.shatteredpixel.shatteredpixeldungeon.items.armor;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class FabricArmor extends Armor {
    {
        image = ItemSpriteSheet.ARMOR_CLOTH; //todo 천갑옷 스프라이트 추가
        bones = false;
    }

    public FabricArmor() {
        super(1);
    }
}
