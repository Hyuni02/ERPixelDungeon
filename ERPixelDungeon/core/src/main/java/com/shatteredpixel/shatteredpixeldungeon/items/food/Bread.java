package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Bread extends Food{
    {
        image = ItemSpriteSheet.RATION; //todo 빵 이미지 변경
        energy = Hunger.HUNGRY;
    }
}
