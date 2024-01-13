package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class UndercookedSteak  extends Food{
    {
        image = ItemSpriteSheet.STEWED; //todo 레어 스테이크 이미지 변경
        energy = Hunger.HUNGRY/2;
    }
}
