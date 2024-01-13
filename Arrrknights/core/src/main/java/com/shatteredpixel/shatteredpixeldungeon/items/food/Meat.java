package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MeatPower_Mystery;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Roots;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Slow;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.WellFed;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.items.AnnihilationGear;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.Random;

public class Meat extends Food {
    {
        image = ItemSpriteSheet.MEAT;
        energy = Hunger.HUNGRY / 2f;
    }

    @Override
    protected void satisfy(Hero hero) {
        super.satisfy(hero);
        effect(hero);
    }

    public int value() {
        return 5 * quantity;
    }

    public static void effect(Hero hero) {
        if (Dungeon.hero.hasTalent(Talent.CARNIVORE)) {
            DeviceCompat.log("GAME", "육식주의 발동");
            Dungeon.hero.HP = Math.min(Dungeon.hero.HT, Dungeon.hero.HP + 3 * Dungeon.hero.pointsInTalent(Talent.CARNIVORE));
            if (Dungeon.hero.pointsInTalent(Talent.CARNIVORE) != 2) {
                switch (Random.Int(8)) { //todo 고기 디버프 변경
                    case 0:
                        GLog.w(Messages.get(MysteryMeat.class, "hot"));
                        Buff.affect(hero, Burning.class).reignite(hero);
                        break;
                    case 1:
                        GLog.w(Messages.get(MysteryMeat.class, "legs"));
                        Buff.prolong(hero, Roots.class, Roots.DURATION * 2f);
                        break;
                    case 2:
                        GLog.w(Messages.get(MysteryMeat.class, "not_well"));
                        Buff.affect(hero, Poison.class).set(hero.HT / 5);
                        break;
                    case 3:
                        GLog.w(Messages.get(MysteryMeat.class, "stuffed"));
                        Buff.prolong(hero, Slow.class, Slow.DURATION);
                        break;
                }
            }
        } else {
            switch (Random.Int(5)) { //todo 고기 디버프 변경
                case 0:
                    GLog.w(Messages.get(MysteryMeat.class, "hot"));
                    Buff.affect(hero, Burning.class).reignite(hero);
                    break;
                case 1:
                    GLog.w(Messages.get(MysteryMeat.class, "legs"));
                    Buff.prolong(hero, Roots.class, Roots.DURATION * 2f);
                    break;
                case 2:
                    GLog.w(Messages.get(MysteryMeat.class, "not_well"));
                    Buff.affect(hero, Poison.class).set(hero.HT / 5);
                    break;
                case 3:
                    GLog.w(Messages.get(MysteryMeat.class, "stuffed"));
                    Buff.prolong(hero, Slow.class, Slow.DURATION);
                    break;
            }
        }

        if (hero.hasTalent(Talent.GOODMEAT)) {
            AnnihilationGear Gear = hero.belongings.getItem(AnnihilationGear.class);
            if (hero.belongings.getItem(AnnihilationGear.class) != null && Gear.charge < Gear.chargeCap) {
                Gear.SPCharge(1);
            }
        }

        if (hero.hasTalent(Talent.LOVEMEAT)) {
            Buff.affect(hero, WellFed.class).set(hero.pointsInTalent(Talent.LOVEMEAT) * 20);
            hero.HP = Math.min(Dungeon.hero.HP + hero.pointsInTalent(Talent.LOVEMEAT) * 3, hero.HT);
        }
    }
}
