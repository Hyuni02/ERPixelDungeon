package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Hatchet extends MeleeWeapon{
    {
        image = ItemSpriteSheet.HATCHET;
        hitSound = Assets.Sounds.HIT_SWORD; //todo 손도끼 사운드 추가
        hitSoundPitch = 1.1f;

        tier = 1;

        bones = false;
    }
}
