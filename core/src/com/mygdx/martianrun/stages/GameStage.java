package com.mygdx.martianrun.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.martianrun.actors.Background;
import com.mygdx.martianrun.actors.Enemy;
import com.mygdx.martianrun.actors.Ground;
import com.mygdx.martianrun.actors.Runner;
import com.mygdx.martianrun.utils.BodyUtils;
import com.mygdx.martianrun.utils.WorldUtils;
import javafx.scene.shape.Rectangle;

/**
 * Created by hiro on 18/11/16.
 */
public class GameStage extends Stage implements ContactListener {

    // This will be our viewport measurements while working with the debug renderer
    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 13;

    private World world;
    private Ground ground;
    private Runner runner;
//    private Enemy enemy;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenRightSide;
    private Rectangle screenLeftSide;

    private Vector3 touchPoint;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpWorld();
        setUpCamera();
        setUpTouchControlAreas();
//        renderer = new Box2DDebugRenderer();
    }

    public void setUpWorld() {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpBackground();
        setUpGround();
        setUpRunner();
        createEnemy();
    }

    public void setUpBackground() {
        addActor(new Background());
    }

    public void setUpRunner() {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }

    public void setUpGround() {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setUpCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    public void setUpTouchControlAreas() {
        touchPoint = new Vector3();
        screenLeftSide = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth /2, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }


    // starting the simulation
    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for(Body body : bodies) {
            update(body);
        }

        // Fixed TimeStamp
        accumulator += delta;

        while(accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
    }

    private void update(Body body) {
//        System.out.println("In the update function");
        if(!BodyUtils.bodyInBounds(body)) {
            System.out.println("CHECKING THE FUNCTION");
            if(BodyUtils.bodyIsEnemey(body) && !runner.isHit()) {
                createEnemy();
            }
            world.destroyBody(body);
        }
    }

    public void createEnemy() {
        System.out.println("Inside the createEnemy function");
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
        addActor(enemy);
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        translateScreenToWorldCoordinates(x, y);
        if(rightSideTouched(touchPoint.x, touchPoint.y)) {
            runner.jump();
        }
        else if(leftSideTouched(touchPoint.x, touchPoint.y)) {
            runner.dodge();
        }
        return super.touchDown(x, y, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if(runner.isDodging()) {
            runner.stopDodge();
        }

        return  super.touchUp(screenX, screenY, pointer, button);
    }

    public boolean rightSideTouched(float x, float y) {
        return  screenRightSide.contains(x, y);
    }

    public boolean leftSideTouched(float x, float y) {
        return screenLeftSide.contains(x, y);
    }

    /**
     *  Helper function to get the actual coordinates in my world
     *  @param x
     *  @param y
     */
    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    @Override
    public void beginContact(Contact contact) {

        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsEnemey(b)) || (BodyUtils.bodyIsRunner(b) && BodyUtils.bodyIsEnemey(a))){
            runner.hit();
        }
        else if((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) || (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            System.out.println("The runner has landed");
            runner.landed();
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
