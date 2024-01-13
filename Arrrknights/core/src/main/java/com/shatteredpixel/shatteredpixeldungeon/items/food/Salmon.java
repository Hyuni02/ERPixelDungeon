package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Salmon extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 연어 이미지 변경
        energy = Hunger.HUNGRY/2;
    }
}
