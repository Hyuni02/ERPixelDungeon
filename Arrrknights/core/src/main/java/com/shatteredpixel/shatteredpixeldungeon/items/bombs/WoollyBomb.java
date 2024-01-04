/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.bombs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Corruption;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hex;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Weakness;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Sheep;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.FlameParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.ShadowParticle;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.BArray;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class WoollyBomb extends Bomb {
	
	{
		image = ItemSpriteSheet.WOOLY_BOMB;
	}
	
	@Override
	public void explode(int cell) {

		PathFinder.buildDistanceMap(cell, BArray.not(Dungeon.level.solid, null), 2);
		for (int cell2 = 0; cell2 < PathFinder.distance.length; cell2++) {
			if (PathFinder.distance[cell2] < Integer.MAX_VALUE) {
				Char mob = Actor.findChar(cell2);
				CellEmitter.get(cell2).burst(ShadowParticle.CURSE, 5);

				if (mob instanceof Hero) {
					Buff.affect(mob, Hex.class, 40f);
					Buff.affect(mob, Weakness.class, 40f);
				} else if (mob instanceof Mob) { if (mob.alignment != Char.Alignment.ALLY) {
						if (!mob.isImmune(Corruption.class)) {
							Buff.affect(mob, Corruption.class);

							if (mob.buff(Corruption.class) != null) {
								if (mob.isAlive() && !mob.isImmune(Corruption.class)) { ((Mob)mob).rollToDropLoot(); }
								Statistics.enemiesSlain++;
								Badges.validateMonstersSlain();
								Statistics.qualifiedForNoKilling = false;
								if (((Mob) mob).EXP > 0 && curUser.lvl <= ((Mob) mob).maxLvl) {
									curUser.sprite.showStatus(CharSprite.POSITIVE, Messages.get(mob, "exp", ((Mob) mob).EXP));
									curUser.earnExp(((Mob) mob).EXP, mob.getClass());
								} else {
									curUser.earnExp(0, mob.getClass());
								}
							}
						}
					}
				}
			}
		}

		Sample.INSTANCE.play(Assets.Sounds.PUFF);
		Sample.INSTANCE.play(Assets.Sounds.CURSED);
	}
	
	@Override
	public int value() {
		//prices of ingredients
		return quantity * (20 + 30);
	}
}
