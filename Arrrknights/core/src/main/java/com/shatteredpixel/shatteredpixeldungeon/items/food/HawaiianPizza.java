package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class HawaiianPizza extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 하와이안 피자 이미지 변경
        energy = Hunger.HUNGRY;
    }
}
