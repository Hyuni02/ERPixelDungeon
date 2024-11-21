package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Blackperro;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Closure;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.GreenCat;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.SkinModel;
import com.shatteredpixel.shatteredpixeldungeon.items.Amulet;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.standard.RitualSiteRoom;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.tiles.CustomTilemap;
import com.watabou.noosa.Group;
import com.watabou.noosa.Tilemap;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

import java.util.Arrays;

// 앞으로 신규 레벨 베이스는 이거로 하고 "베이스,건드리지 말것" 부분만 수정한 다음 세부적으로 하는 식으로!
public class NewRhodesLevel1 extends Level {

        {
            color1 = 0x801500;
            color2 = 0xa68521;

            viewDistance = 99;
        }

        @Override
        public String tilesTex () {
        return Assets.Environment.TILSE_RHODES;
    }

        @Override
        public String waterTex () {
        return Assets.Environment.WATER_PRISON;
    }

        @Override
        public void create () {
        super.create();
        for (int i = 0; i < length(); i++) {
            int flags = Terrain.flags[map[i]];
            if ((flags & Terrain.PIT) != 0) {
                passable[i] = avoid[i] = false;
                solid[i] = true;
            }
        }
    }

        private static final int ROOM_TOP = 6;

        @Override
        protected boolean build () {

        setSize(18, 26);
        Arrays.fill(map, Terrain.CHASM);

        // 0이 가장 왼쪽 ~ 위쪽임. 1 늘어날 때마다 오른쪽 / 아래쪽으로 1칸
        // X랑 Y는 위치. W랑 H는 각각 길이/너비 같은거임. W랑 H는 최소 1 이상의 값을 줘야함.
        // 0,0,10,1 을 하면 X,Y가 0,0인 위치에서 시작해서 가로로 10칸, 세로로 1칸 크기로 한다는 것.
        // 주의 사항 : 최대값은 위의 setSize 값의 -1임. 그러니까 x값 합이 18이 되도록 하면 버그남.

        // 베이스. 건드리지 말 것
        Painter.fill(this, 0, 0, 18, 26, Terrain.EMPTY);
        Painter.fill(this, 0, 0, 18, 1, Terrain.CHASM);
        Painter.fill(this, 0, 25, 18, 1, Terrain.CHASM);
        Painter.fill(this, 0, 0, 1, 25, Terrain.CHASM);
        Painter.fill(this, 17, 0, 1, 25, Terrain.CHASM);

        // 28층 올라가는 부분 관련.
        Painter.fill(this, 1, 1, 16, 13, Terrain.AVOID);
        // 28층 올라가는 부분 = 계단 근처
        Painter.fill(this, 6, 9, 6, 6, Terrain.EMPTY);

        // 계단 관련
        Painter.fill(this, 7, 21, 4, 4, Terrain.ENTRANCE); // 1층 가는거
        Painter.fill(this, 6, 9, 6, 2, Terrain.EXIT); // 28층 가는거.

        // 벽 관련
        // 1. 처음 입구부분 벽
        Painter.fill(this, 1, 19, 6, 6, Terrain.CHASM);
        Painter.fill(this, 11, 19, 6, 6, Terrain.CHASM);

        // 2.
       Painter.fill(this, 1, 18, 4, 1, Terrain.CHASM);
       Painter.fill(this, 13, 18, 4, 1, Terrain.CHASM);

        // 3.
       Painter.fill(this, 1, 18, 4, 1, Terrain.CHASM);
       Painter.fill(this, 13, 18, 4, 1, Terrain.CHASM);

        // 4.
        Painter.fill(this, 1, 17, 3, 1, Terrain.CHASM);
        Painter.fill(this, 14, 17, 3, 1, Terrain.CHASM);

        entrance = 369;
        exit = 189;

        feeling = Feeling.NONE;

            CustomeMap vis = new CustomeMap();
            vis.setRect(0, 0, width(), height());
            customTiles.add(vis);

        return true;
    }

        @Override
        protected void createMobs () {
    }

        public Actor addRespawner () {
        return null;
    }

        @Override
        protected void createItems () {
     //   if (Dungeon.hero.belongings.getItem(Amulet.class) == null) GreenCat.spawn(this, exit);
     //   SkinModel.spawn(this, 255);
        Blackperro.spawn(this, 245);
    }

        @Override
        public int randomRespawnCell (Char ch ){
        int cell;
        do {
            cell = entrance + PathFinder.NEIGHBOURS8[Random.Int(8)];
        } while (!passable[cell]
                || (Char.hasProp(ch, Char.Property.LARGE) && !openSpace[cell])
                || Actor.findChar(cell) != null);
        return cell;
    }


        @Override
        public Group addVisuals () {
        super.addVisuals();
        HallsLevel.addHallsVisuals(this, visuals);
        return visuals;
    }

        @Override
        public void restoreFromBundle (Bundle bundle){
        super.restoreFromBundle(bundle);
    }

    public static class CustomeMap extends CustomTilemap {

        {
            texture = Assets.Environment.RHODES_27F;
        }

        @Override
        public Tilemap create() {
            Tilemap v = super.create();
            int[] data = new int[tileW*tileH];
            for (int i = 0; i < data.length; i++){
                    data[i] = i;
            }

            v.map( data, tileW );
            return v;
        }
    }
}
