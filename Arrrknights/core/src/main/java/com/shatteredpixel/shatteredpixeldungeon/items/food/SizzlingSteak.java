package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class SizzlingSteak extends Food{
    {
        image = ItemSpriteSheet.STEAK; //todo 웰던 스테이크 이미지 변경
        energy = Hunger.HUNGRY;
    }
}
