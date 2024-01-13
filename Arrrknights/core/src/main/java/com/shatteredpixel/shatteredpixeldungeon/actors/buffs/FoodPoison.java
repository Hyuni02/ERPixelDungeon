package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;

public class FoodPoison extends FlavourBuff{
    {
        type = buffType.NEGATIVE;
    }

    public static final float DURATION	= 7f;

    @Override
    public boolean attachTo( Char target ) {
        if (super.attachTo( target )) {
            Dungeon.hero.STR -=1;
            Roots.detach( target, Roots.class );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void detach() {
        Dungeon.hero.STR +=1;
        super.detach();
    }

    @Override
    public int icon() {
        return BuffIndicator.RAGE; //todo 식중독 아이콘 변경
    }

    @Override
    public float iconFadePercent() {
        return Math.max(0, (DURATION - visualcooldown()) / DURATION);
    }

    @Override
    public String toString() {
        return Messages.get(this, "name");
    }

    @Override
    public String desc() {
        return Messages.get(this, "desc", dispTurns());
    }
}
