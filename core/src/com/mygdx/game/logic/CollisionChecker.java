package com.mygdx.game.logic;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.DataTypes.DirectPoint;

import java.awt.Point;
import java.util.ArrayList;

public class CollisionChecker {
    public boolean checkMap(MapLayers collisionLayers, DirectPoint point) {
        ArrayList<Point> points = new ArrayList<>();
        if(point.direction.equals("f"))
            points = getForwardTankPositions(point.x, point.y);
        if(point.direction.equals("b"))
            points = getBackTankPositions(point.x, point.y);
        if(point.direction.equals("l"))
            points = getLeftTankPositions(point.x, point.y);
        if (point.direction.equals("r"))
            points = getRightTankPositions(point.x, point.y);

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < collisionLayers.size(); j++) {
                TiledMapTileLayer collisionLayer = (TiledMapTileLayer) collisionLayers.get(i);
                float tileWidth = collisionLayer.getTileWidth();
                float tileHeight = collisionLayer.getTileHeight();
                try {
                    if ((boolean) collisionLayer.getCell((int) (points.get(i).x / tileWidth), (int) (points.get(i).y / tileHeight)).getTile().getProperties().get("isWall")) {
                        return false;
                    }
                }catch (Exception ignored){
                }
            }
        }
        return true;
    }

    public boolean checkMapBorders(Point point){
        return point.x >= 0 && point.x <= 770 && point.y >= 0 && point.y <= 800;
    }

    public ArrayList<Point> getTankPositions(float x, float y){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point((int) x, (int) y + 1));
        points.add(new Point((int) x + 1, (int) y + 1));
        points.add(new Point((int) x, (int) y));
        points.add(new Point((int) x + 1, (int) y));
        return points;
    }

    //forward
    public ArrayList<Point> getForwardTankPositions(float x, float y){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point((int) x, (int) y + 64));
        points.add(new Point((int) x + 64, (int) y + 64));
        return points;
    }

    //right
    public ArrayList<Point> getRightTankPositions(float x, float y){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point((int) x + 64, (int) y + 64));
        points.add(new Point((int) x + 64, (int) y));
        return points;
    }

    //left
    public ArrayList<Point> getLeftTankPositions(float x, float y){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point((int) x, (int) y + 64));
        points.add(new Point((int) x, (int) y));
        return points;
    }

    //Back
    public ArrayList<Point> getBackTankPositions(float x, float y){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point((int) x, (int) y));
        points.add(new Point((int) x + 64, (int) y));
        return points;
    }
}
