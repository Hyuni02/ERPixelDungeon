package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class BreadInTears extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 눈젖빵 이미지 변경
        energy = Hunger.HUNGRY;
    }
}
