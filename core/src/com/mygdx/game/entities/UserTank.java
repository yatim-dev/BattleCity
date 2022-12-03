package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.logic.Move;

import java.awt.Point;
import java.util.ArrayList;

public class UserTank extends Sprite {

    private MapLayers collisionLayers;
    private Point movePoint;
    Move move;

    public UserTank(Sprite sprite, MapLayers collisionLayers){
        super(sprite);
        this.move = new Move(collisionLayers);
        this.collisionLayers = collisionLayers;
    }

    @Override
    public void draw(Batch spriteBatch) {
        update();
        super.draw(spriteBatch);

    }

    public void update() {
        movePoint = new Point(move.moveWASD(getX(), getY()));
        setX((float) movePoint.x);
        setY((float) movePoint.y);
    }
}
