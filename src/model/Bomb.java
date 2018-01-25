package model;

import controller.Main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends GameFigure {

    // missile size
    private static final int SIZE = 30;
    private static final int MAX_EXPLOSION_SIZE = 150;
    private int time = 0;

    // public properties for quick access
    public Color color;
    public Point2D.Float target;

    private static final int UNIT_TRAVEL_DISTANCE = 5; // per frame move

    private int size = SIZE;

    /**
     *
     * @param sx start x of the missile
     * @param sy start y of the missile
     * @param tx target x of the missile
     * @param ty target y of the missile
     * @param color color of the missile
     */
    public Bomb(float sx, float sy, float tx, float ty, Color color) {
        super(tx, ty);
        super.state = GameFigureState.MISSILE_STATE_LAUNCHED;
        this.target = new Point2D.Float(tx, ty);
        this.color = color;

        double angle = Math.atan2(ty - sy, tx - sx);
    }

    @Override
    public void render(Graphics2D g) {
        if (state == GameFigureState.MISSILE_STATE_EXPLODED)
            color = new Color(255,87,34);
        g.setColor(color);
        g.setStroke(new BasicStroke(2)); // thickness of the line
        g.fillOval((int) (super.x - size / 2),
                (int) (super.y - size / 2),
                size, size);
        }

    @Override
    public void update() {
        updateState();
        if (state == GameFigureState.MISSILE_STATE_LAUNCHED) {
            updateTime();
        } else if (state == GameFigureState.MISSILE_STATE_EXPLODED) {
            updateSize();
        }
    }

    public void updateTime() {
        
        time++;
    }

    public void updateSize() {
        size += 6;
    }

    public void updateState() {
        if (state == GameFigureState.MISSILE_STATE_LAUNCHED) {
            boolean targetReached = (time >= 60);
            if (targetReached) {
                state = GameFigureState.MISSILE_STATE_EXPLODED;
            }
        } else if (state == GameFigureState.MISSILE_STATE_EXPLODED) {
            if (size >= MAX_EXPLOSION_SIZE) {
                state = GameFigureState.STATE_DONE;
            }
        }
    }
    @Override
    public Rectangle2D.Float getCollisionBox(){
        return new Rectangle2D.Float(super.x, super.y, size, size);
    }
}
