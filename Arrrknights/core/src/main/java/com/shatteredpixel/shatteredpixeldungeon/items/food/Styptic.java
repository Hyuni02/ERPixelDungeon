package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bleeding;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Styptic  extends Food{
    {
        image = ItemSpriteSheet.PASTY; //todo 지혈제 이미지 변경
        energy = Hunger.HUNGRY/4;
    }

    @Override
    protected void satisfy(Hero hero) {
        Buff.detach(hero, Bleeding.class);
        super.satisfy(hero);
    }
}
