package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class FrozenPizza extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 냉동피자 이미지 변경
        energy = Hunger.HUNGRY/2;
    }
}
