package com.mygdx.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapLayers;
import com.mygdx.game.DataTypes.DirectPoint;

import java.awt.Point;
import java.util.ArrayList;

public class Move {

    CollisionChecker collisionChecker;
    MapLayers collisionLayers;

    public Move(MapLayers collisionLayers) {
        this.collisionLayers = collisionLayers;
        this.collisionChecker = new CollisionChecker();
    }

    public Point moveWASD(float x, float y) {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            if(collisionChecker.checkMap(collisionLayers, new DirectPoint((int) x, (int) y, "l")) && collisionChecker.checkMapBorders(new Point((int) x - 1, (int) y)))
                return new Point((int) x - 1, (int) y);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(collisionChecker.checkMap(collisionLayers, new DirectPoint((int) x, (int) y, "r")) && collisionChecker.checkMapBorders(new Point((int) x + 1, (int) y)))
                return new Point((int) x + 1, (int) y);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(collisionChecker.checkMap(collisionLayers, new DirectPoint((int) x, (int) y, "f")) && collisionChecker.checkMapBorders(new Point((int) x, (int) y + 1)))
                return new Point((int) x, (int) y + 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            if(collisionChecker.checkMap(collisionLayers, new DirectPoint((int) x, (int) y, "b")) && collisionChecker.checkMapBorders(new Point((int) x, (int) y - 1)))
                return new Point((int) x, (int) y - 1);
        }
        return new Point((int) x, (int) y);
    }

    public Point moveKeyboardArrow(float x, float y) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            return new Point((int) x - 1, (int) y);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            return new Point((int) x + 1, (int) y);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            return new Point((int) x, (int) y + 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            return new Point((int) x, (int) y - 1);
        }
        return new Point((int) x, (int) y);
    }


}
