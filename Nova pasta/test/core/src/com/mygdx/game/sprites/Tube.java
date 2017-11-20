package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    public static final int TUBE_WIDTH = 52;

    private Texture topTube, bottumTube;
    private Vector2 posTopTube, posBotTube;
    private Rectangle boundsTop, boundsBot;
    private Random rand;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottumTube = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x,posTopTube.y - TUBE_GAP - bottumTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottumTube.getWidth(), bottumTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottumTube() {
        return bottumTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y - TUBE_GAP - bottumTube.getHeight());
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop)  || player.overlaps(boundsBot);
    }

    public void  dispose() {
        bottumTube.dispose();
        topTube.dispose();
    }
}
