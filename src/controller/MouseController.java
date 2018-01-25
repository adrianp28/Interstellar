package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Bomb;
import model.Bullet;
import model.GameFigure;
import model.Missile;
import model.Shooter;

public class MouseController extends MouseAdapter {
    
    public int x;
    public int y;
    Color myBlue = new Color(3, 169, 244);
    Color myGrey = new Color(158,158,158);
    Color myBrown = new Color(121,85,72);
    @Override
    public void mousePressed(MouseEvent me) {
        
        int px = me.getX();
        int py = me.getY();

        Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
        GameFigure m;
        if(!shooter.overheated){
            switch(shooter.weapon){
                case "Bullet":
                    m = new Bullet(
                    shooter.getXofMissileShoot(),
                    shooter.getYofMissileShoot(),
                    px, py, // target location where the missile explodes
                    myBlue);
                    shooter.weaponHeat-=10;
                    break;
                case "Missile":
                    m = new Missile(
                    shooter.getXofMissileShoot(),
                    shooter.getYofMissileShoot(),
                    px, py, // target location where the missile explodes
                    myGrey);
                    shooter.weaponHeat-=30;
                    break;
                case "Bomb":
                    m = new Bomb(
                    shooter.getXofMissileShoot(),
                    shooter.getYofMissileShoot(),
                    px, py, // target location where the missile explodes
                    myBrown);
                    shooter.weaponHeat-=90;
                    break;
                default:
                    m = new Bullet(
                    shooter.getXofMissileShoot(),
                    shooter.getYofMissileShoot(),
                    px, py, // target location where the missile explodes
                    myBlue);
                    break;

            }
            Main.gameData.friendFigures.add(m);
        }
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

}
