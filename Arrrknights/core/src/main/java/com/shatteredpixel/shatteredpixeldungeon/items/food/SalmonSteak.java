package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class SalmonSteak extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 연어 스테이크 이미지 변경
        energy = Hunger.HUNGRY;
    }
}
