package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class TearOfSelene extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 셀레네의 눈물 이미지 변경
        energy = Hunger.HUNGRY/3;
    }

    @Override
    protected void satisfy(Hero hero) {
        Dungeon.hero.STR += 1;
        super.satisfy(hero);
    }
}
