package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class ColdNoodles extends Food {
    {
        image = ItemSpriteSheet.PASTY; //todo 냉면 이미지 변경
        energy = Hunger.HUNGRY;
    }

    @Override
    protected void satisfy(Hero hero) {
        Buff.detach(hero, Burning.class);
        super.satisfy(hero);
    }
}
