package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Dummy;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;

public class Runaway extends FlavourBuff{
    {
        type = buffType.POSITIVE;
    }

    @Override
    public boolean attachTo( Char target ) { //todo 지속시간이 추가 형식이 아닌 초기화 형식으로 변경되어야 함
        if (super.attachTo( target )) {
            Dungeon.hero.STR +=2;
            Roots.detach( target, Roots.class );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void detach() {
        Dungeon.hero.STR -=2;
        super.detach();
    }

    @Override
    public int icon() {
        return BuffIndicator.RAGE; //todo 폭주 아이콘 변경
    }

    @Override
    public float iconFadePercent() {
        return Math.max(0, (4 * Dungeon.hero.pointsInTalent(Talent.RUNAWAY) - visualcooldown()) / 4 * Dungeon.hero.pointsInTalent(Talent.RUNAWAY));
    }

    @Override
    public String toString() {
        return Messages.get(this, "name");
    }

    @Override
    public String desc() {
        return Messages.get(this, "desc", 2 * Dungeon.hero.pointsInTalent(Talent.RUNAWAY), dispTurns());
    }
}
