package com.akkunsoft.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 * Created by Akkun on 2017-03-07.
 */

public class Tube {
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    public static final int TUBE_WIDTH = 100;//52;
    private static final int LOWEST_OPENING = 120;
    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBottomTube;
    private Rectangle topCollider, bottomCollider;
    private Random rand;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBottomTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        topCollider = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        bottomCollider = new Rectangle(posBottomTube.x, posBottomTube.y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBottomTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        topCollider.setPosition(posTopTube.x, posTopTube.y);
        bottomCollider.setPosition(posBottomTube.x, posBottomTube.y);
    }

    public boolean collides (Rectangle bird){
        return bird.overlaps(topCollider) || bird.overlaps(bottomCollider);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}
