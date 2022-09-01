package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 600;
	ShapeRenderer shapeRenderer;

	private float fighterX = 200;
	private float fighterY = 100;

	private float oppX = 1000;
	private float oppY = 100;

	private int moveSpeed = 5;

	private Hitbox fighter1  = new Hitbox(fighterX, fighterY, 25, 75);;
	private Hitbox fighter2 = new Hitbox(oppX, oppY, 25, 75);

	@Override
	public void create() {
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render() {
		if(Gdx.input.isKeyPressed(Input.Keys.A) && fighter1.getX() > 0){
			fighter1.move(moveSpeed * -1);
			if (!fighter1.notTouching(fighter2)) {
				fighter1.move(moveSpeed);
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.D) && fighter1.getX() < WIDTH - fighter1.getWidth()){
			fighter1.move(moveSpeed);
			if (!fighter1.notTouching(fighter2)) {
				fighter1.move(moveSpeed * -1);
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && fighter2.getX() > 0){
			fighter2.move(moveSpeed * -1);
//			if (!fighter2.notTouching(fighter1)) {
//				fighter2.setX(fighter2.getX() + moveSpeed);
//			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && fighter2.getX() < WIDTH - fighter2.getWidth()){
			fighter2.move(moveSpeed);
//			if (!fighter2.notTouching(fighter1)) {
//				fighter2.setX(fighter2.getX() - moveSpeed);
//			}
		}

		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.rect(fighter1.getX(), fighter1.getY(), fighter1.getWidth(), fighter1.getHeight());
		shapeRenderer.end();

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(1, 0, 0, 1);
		shapeRenderer.rect(fighter2.getX(), fighter2.getY(), fighter2.getWidth(), fighter2.getHeight());
		shapeRenderer.end();
	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
	}
}
