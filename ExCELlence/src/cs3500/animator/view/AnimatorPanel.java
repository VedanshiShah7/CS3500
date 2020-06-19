package cs3500.animator.view;


import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.commands.AnimatorCommand;
import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.model.shapes.ShapesModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import java.time.Clock;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Represent the Panel to display the animation. Used to create the panel which is used by the
 * JFrame. It represents the region where the animation must be drawn. It is a container that
 * represents custom drawing.
 */
public class AnimatorPanel extends JPanel implements ActionListener {

  private AnimatorModel model;
  private double tickspeed; // made the tickspeed double
  private double currentTime;
  private Timer clock;

  /**
   * Represent the default constructor for the animation Panel to take in Shapes and speed of
   * animation.
   *
   * @param model     represent the model to animate
   * @param tickspeed represent the speed of the animation. (need more information about how to
   *                  implement it)
   */
  public AnimatorPanel(AnimatorModel model, double tickspeed) { // made the tickspeed double
    super();
    this.model = model;
    this.tickspeed = tickspeed;
    this.currentTime = 1.0;
    this.clock = new Timer((int) (1000 / this.tickspeed), this); // had to cast to int
  }


  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    AffineTransform originalTransform = g2d.getTransform();
    for (ShapesModel s : this.model.getShapes()) {
      // Make sure that the shape doesn't appear before the first animation
      Integer minTime = null;
      Integer maxTime = null;

      for (AnimatorCommand a : s.getCommands()) {
        if (minTime == null || minTime > a.getStart()) {
          minTime = (int) a.getStart();
        }
        if (maxTime == null || maxTime < a.getStop()) {
          maxTime = (int) a.getStop();
        }
        if (this.currentTime >= minTime && this.currentTime <= maxTime) {
          if (s instanceof Rectangle) {
            g2d.fillRect((int) s.getPosition().getX(), (int) s.getPosition().getY()
                    , (int) s.getDimension().getWidth(), (int) s.getDimension().getHeight());
            g2d.setColor(new Color((int) s.getColor().getR(), (int) s.getColor().getG(),
                    (int) s.getColor().getB()));
          } else {
            g2d.fillOval((int) s.getPosition().getX(), (int) s.getPosition().getY()
                    , (int) s.getDimension().getWidth(), (int) s.getDimension().getHeight());
            g2d.setColor(new Color((int) s.getColor().getR(), (int) s.getColor().getG(),
                    (int) s.getColor().getB()));
          }
        }
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (ShapesModel s : this.model.getShapes()) {
      System.out.println(this.currentTime);
      System.out.println(s.getColor().toString());
      s.updateAnimatorClock(this.currentTime);
      s.runAnimation();
      this.repaint();
    }
    this.currentTime = this.currentTime + 1;
  }

  // Preparing for assignment 7, thus it is not part of assignment 6 interface
  public void pauseAnimation() {
    this.clock.stop();
  }

  public void startAnimation() {
    this.clock.start();
  }

  public void restartAnimation() {
    this.clock.restart();
    this.currentTime = 1;
  }



  /**
   * Allow the client to modify the change tick speed of the animation.
   */
  public void changeTickSpeed(int framePerSecond) {
    this.tickspeed = framePerSecond;
  }

}