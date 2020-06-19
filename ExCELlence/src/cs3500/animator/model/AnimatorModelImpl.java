package cs3500.animator.model;

import cs3500.animator.model.commands.AnimatorCommand;
import cs3500.animator.model.commands.ChangeColor;
import cs3500.animator.model.commands.ChangeSize;
import cs3500.animator.model.commands.Move;
import cs3500.animator.model.shapes.CartPosition;
import cs3500.animator.model.shapes.Oval;
import cs3500.animator.model.shapes.RGBColor;
import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.model.shapes.ShapesModel;
import cs3500.animator.util.AnimationBuilder;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the animator model implementation class that extends the animator model and all its
 * methods. It is used in the constructor to animate objects of ShapeModel.
 */
public class AnimatorModelImpl implements AnimatorModel {

  protected final int height;
  protected final int width;
  protected final int leftMost;
  protected final int topMost;
  protected Map<String, ShapesModel> shapes;
  protected double clock;

  /**
   * Constructor for animator model implementation class that does not take in any inputs.
   */
  public AnimatorModelImpl() {
    this.height = 500;
    this.width = 500;
    this.shapes = new HashMap<>();
    this.leftMost = 0;
    this.topMost = 0;
    this.clock = 0;
  }

  /**
   * Constructor to construct the Animation World with Height and Width and desired tick speed.
   *
   * @param height   represent the height of the window
   * @param width    represent the width of the window
   * @param leftMost represent the leftMost value of the animation
   * @param topMost  represent the topMost value of the animation
   */
  public AnimatorModelImpl(int height, int width, int leftMost, int topMost) {
    if (height > 0 && width > 0) {
      this.height = height;
      this.width = width;
      this.shapes = new HashMap<String, ShapesModel>();
      this.leftMost = leftMost;
      this.topMost = topMost;
      this.clock = 0;
    } else {
      throw new IllegalArgumentException("Height Width and Tickspeed must be positive");
    }
  }

  /**
   * Constructor to construct the Animation World with Height and Width and desired shapes.
   *
   * @param height   represent the height of the window
   * @param width    represent the width of the window
   * @param topMost  represent the topMost value of the animation
   * @param leftMost represent the leftMost value of the animation
   * @param shapes   represent the shapes inside this animator
   */
  public AnimatorModelImpl(int height, int width, int leftMost, int topMost,
      HashMap<String, ShapesModel> shapes) {
    if (height > 0 && width > 0) {
      this.height = height;
      this.width = width;
      this.shapes = shapes;
      this.leftMost = leftMost;
      this.topMost = topMost;
      this.clock = 0;
    } else {
      throw new IllegalArgumentException("Height Width and Tickspeed must be positive");
    }
  }

  /**
   * Constructor to construct the Animation World with custom parameters.
   *
   * @param height   represent the height of the window
   * @param width    represent the width of the window
   * @param topMost  represent the topMost value of the animation
   * @param leftMost represent the leftMost value of the animation
   * @param shapes   represent a list of shapes in this Animation World
   * @param clock    represent the clock for this animation world
   */
  public AnimatorModelImpl(int height, int width, int leftMost, int topMost,
      HashMap<String, ShapesModel> shapes, double clock) {
    if (clock > 0 && height > 0 && width > 0) {
      this.height = height;
      this.width = width;
      this.leftMost = leftMost;
      this.topMost = topMost;
      this.shapes = shapes;
      this.clock = clock;
    } else {
      throw new IllegalArgumentException("Height Width and Tickspeed must be positive");
    }
  }

  @Override
  public void addShape(ShapesModel s) {
    // should we allow duplicate shapes?
    shapes.put(s.getName(), s);
  }

  @Override
  public void removeShape(ShapesModel s) {
    if (shapes.containsKey(s.getName())) {
      shapes.remove(s.getName());
    } else {
      throw new IllegalArgumentException("This shape does not exist.");
    }
  }

  @Override
  public void moveShape(ShapesModel s, int fromX, int fromY, int toX, int toY, double start,
      double end) {
    if (shapes.containsKey(s.getName())) {
      AnimatorCommand m = new Move(fromX, fromY, toX, toY, start, end, this.clock);
      s.addMotion(m);
    } else {
      throw new IllegalArgumentException("The shape does not exist.");
    }
  }

  @Override
  public void changeColor(ShapesModel s, int fromR, int fromG, int fromB, int r, int g, int b,
      double start, double stop) {
    if (shapes.containsKey(s.getName())) {
      AnimatorCommand m = new ChangeColor(fromR, fromG, fromB, r, g, b, start, stop, this.clock);
      s.addMotion(m);
    } else {
      throw new IllegalArgumentException("The Shape does not exist.");
    }
  }

  @Override
  public void changeSize(ShapesModel s, int fromw, int fromh, int tow, int toh, double start,
      double stop) {
    if (shapes.containsKey(s.getName())) {
      AnimatorCommand m = new ChangeSize(fromw, fromh, tow, toh, start, stop, this.clock);
      s.addMotion(m);
    } else {
      throw new IllegalArgumentException("The shape does not exist.");
    }
  }

  @Override
  public void insertKeyFrame(ShapesModel s, int x, int y, int r, int g, int b,
      int width, int height, double time) {
    if (shapes.containsKey(s.getName())) {
      // Waiting for reimplementation of edit keyFrame
    }
  }

  @Override
  public String getAnimationState() {
    ArrayList<String> keyset = new ArrayList<>();
    String result = "";
    for (String s : this.shapes.keySet()) {
      keyset.add(s);
    }
    for (int i = 0; i < keyset.size(); i++) {
      if (i == this.shapes.keySet().size() - 1) {
        result += this.shapes.get(keyset.get(i)).getAnimationState(clock);
      } else {
        result += this.shapes.get(keyset.get(i)).getAnimationState(clock) + "\n\n";
      }
    }
    return result;
  }

  @Override
  public String getAnimationStateShape(ShapesModel s) {
    if (shapes.containsKey(s.getName())) {
      return s.getAnimationState(this.clock);
    } else {
      throw new IllegalArgumentException("Shape does not exist.");
    }
  }

  @Override
  public boolean isOver() {
    boolean result = true;

    for (String s : this.shapes.keySet()) {
      result = result && this.shapes.get(s).motionOver(clock);
    }
    return result;
  }

  @Override
  public void runAnimation() {
    while (!this.isOver()) {
      for (String s : this.shapes.keySet()) {
        this.shapes.get(s).updateAnimatorClock(this.clock);
        this.shapes.get(s).runAnimation();
      }
      this.updateClock();
    }

    // Latest run to make sure that end animation work
    for (String s : this.shapes.keySet()) {
      this.shapes.get(s).updateAnimatorClock(this.clock);
      this.shapes.get(s).runAnimation();
    }
  }

  @Override
  public ArrayList<ShapesModel> getShapes() {
    ArrayList<ShapesModel> result = new ArrayList<>();

    for (String s : this.shapes.keySet()) {
      result.add(this.shapes.get(s));
    }
    return result;
  }

  @Override
  public ShapesModel findShape(String name) {
    ShapesModel result = null;

    for (String s : this.shapes.keySet()) {
      if (this.shapes.get(s).getName().equals(name)) {
        result = this.shapes.get(s);
      }
    }

    if (result == null) {
      throw new IllegalArgumentException("Shapes cannot be found");
    } else {
      return result;
    }
  }

  @Override
  public void insertKeyFrame(ShapesModel model, Integer x, Integer y, Integer width, Integer height,
      Integer r, Integer g, Integer b, Integer time) {

    if (x != null && y != null) {
      this.insertMoveCommand(model, x, y, time);
    }

    if (width != null && height != null) {
      this.insertSizeCommand(model, width, height, time);
    }

    if (r != null && g != null && b != null) {
      this.insertColorCommand(model, r, g, b, time);
    }
  }

  private void insertMoveCommand(ShapesModel model, int x, int y, double time) {
    if (model.getMoveCommands().isEmpty()) {
      Move move = new Move(0, 0, x, y, time, time, this.clock);
      model.addMotion(move);
    } else {
      int fromX = x;
      int fromY = y;
      int toX = x;
      int toY = y;
      double startTime = model.getMoveCommands().get(0).getStop();
      double endTime = model.getMoveCommands().get(0).getStart();
      for (Move m : model.getMoveCommands()) {
        // Find the last keyframe in the shape
        startTime = Math.max(startTime, m.getStop());
        // Find the first keyframe in the shape
        endTime = Math.min(endTime, m.getStart());
      }

      for (Move m : model.getMoveCommands()) {
        // Find the stop position of the last keyFrame
        if (Math.abs(m.getStop() - startTime) < 0.01) {
          fromX = m.getPosition()[2];
          fromY = m.getPosition()[3];
        }

        // Find the start position of the first keyFrame
        if (Math.abs(m.getStart() - endTime) < 0.01) {
          toX = m.getPosition()[0];
          toY = m.getPosition()[1];
        }
      }

      if (time > startTime) {
        model.addMotion(new Move(fromX, fromY, x, y, startTime, time, this.clock));
      } else {
        model.addMotion(new Move(x, y, toX, toY, time, endTime, this.clock));
      }
    }
  }


  private void insertSizeCommand(ShapesModel model, int width, int height, double time) {
    if (model.getSizeCommands().isEmpty()) {
      ChangeSize size = new ChangeSize(0, 0, width, height, time, time, this.clock);
      model.addMotion(size);
    } else {
      int fromWidth = width;
      int fromHeight = height;
      int toWidth = width;
      int toHeight = height;
      double startTime = model.getSizeCommands().get(0).getStop();
      double endTime = model.getSizeCommands().get(0).getStart();
      for (ChangeSize s : model.getSizeCommands()) {
        // Find the last keyframe in the shape
        startTime = Math.max(startTime, s.getStop());
        // Find the first keyframe in the shape
        endTime = Math.min(endTime, s.getStart());
      }

      for (ChangeSize s : model.getSizeCommands()) {
        // Find the stop position of the last keyFrame
        if (Math.abs(s.getStop() - startTime) < 0.01) {
          fromWidth = s.getDimension()[2];
          fromHeight = s.getDimension()[3];
        }

        // Find the start position of the first keyFrame
        if (Math.abs(s.getStart() - endTime) < 0.01) {
          toWidth = s.getDimension()[0];
          toHeight = s.getDimension()[1];
        }
      }

      if (time > startTime) {
        model.addMotion(
            new ChangeSize(fromWidth, fromHeight, width, height, startTime, time, this.clock));
      } else {
        model.addMotion(new Move(width, height, toWidth, toHeight, time, endTime, this.clock));
      }
    }
  }

  private void insertColorCommand(ShapesModel model, int r, int g, int b, double time) {
    if (model.getColorCommands().isEmpty()) {
      ChangeColor color = new ChangeColor(0, 0, 0, r, g, b, time, time, this.clock);
      model.addMotion(color);
    } else {
      int fromR = r;
      int fromG = g;
      int fromB = b;
      int toR = r;
      int toG = g;
      int toB = b;
      double startTime = model.getColorCommands().get(0).getStop();
      double endTime = model.getColorCommands().get(0).getStart();
      for (ChangeColor c : model.getColorCommands()) {
        // Find the last keyframe in the shape
        startTime = Math.max(startTime, c.getStop());
        // Find the first keyframe in the shape
        endTime = Math.min(endTime, c.getStart());
      }

      for (ChangeColor c : model.getColorCommands()) {
        // Find the stop position of the last keyFrame
        if (Math.abs(c.getStop() - startTime) < 0.01) {
          fromR = c.getColor()[3];
          fromG = c.getColor()[4];
          fromB = c.getColor()[5];
        }

        // Find the start position of the first keyFrame
        if (Math.abs(c.getStart() - endTime) < 0.01) {
          toR = c.getColor()[0];
          toG = c.getColor()[1];
          toB = c.getColor()[2];
        }
      }

      if (time > startTime) {
        model.addMotion(
            new ChangeColor(fromR, fromG, fromB, r, g, b, startTime, time, this.clock));
      } else {
        model.addMotion(new ChangeColor(r, g, b, toR, toG, toB, time, endTime, this.clock));
      }
    }
  }


  @Override
  public void editKeyFrame(ShapesModel model, Integer x, Integer y, Integer width, Integer height,
      Integer r, Integer g, Integer b, Integer time) {
    ArrayList<AnimatorCommand> listOfCommands = model.getCommands();

    for (AnimatorCommand a : listOfCommands) {
      if (Math.abs(time - a.getStart()) < 0.01) {
        // When the client want to modify that is right on the start motion
        //TODO modify the command object
        if (x != null && y != null) {
          int toX = a.getPosition()[2];
          int toY = a.getPosition()[3];
          double endTime = a.getStop();
          model.removeMotion(a);
          model.addMotion(new Move(x, y, toX, toY, time, endTime,
              this.clock)); // Need to test how the clock work
        }

        if (width != null && height != null) {
          int toWidth = a.getDimension()[2];
          int toHeight = a.getDimension()[3];
          double endTime = a.getStop();
          model.removeMotion(a);
          model.addMotion(
              new ChangeSize(width, height, toWidth, toHeight, time, endTime, this.clock));
        }

        if (r != null && g != null && b != null) {
          int toR = a.getColor()[3];
          int toG = a.getColor()[4];
          int toB = a.getColor()[5];
          double endTime = a.getStop();
          model.removeMotion(a);
          model.addMotion(new ChangeColor(r, g, b, toR, toG, toB, time, endTime, this.clock));
        }

      } else if (Math.abs(time - a.getStop()) < 0.01) {
        // When the client want to modify that is right on the stop motion
        //TODO modify the command object
        if (x != null && y != null) {
          int fromX = a.getPosition()[0];
          int fromY = a.getPosition()[1];
          double startTime = a.getStart();
          model.removeMotion(a);
          model.addMotion(new Move(fromX, fromY, x, y, startTime, time,
              this.clock)); // Need to test how the clock work
        }

        if (width != null && height != null) {
          int fromWidth = a.getDimension()[0];
          int fromHeight = a.getDimension()[1];
          double startTime = a.getStart();
          model.removeMotion(a);
          model.addMotion(
              new ChangeSize(fromWidth, fromHeight, width, height, startTime, time, this.clock));
        }

        if (r != null && g != null && b != null) {
          int fromR = a.getColor()[0];
          int fromG = a.getColor()[1];
          int fromB = a.getColor()[2];
          double startTime = a.getStart();
          model.removeMotion(a);
          model.addMotion(
              new ChangeColor(fromR, fromG, fromB, r, g, b, startTime, time, this.clock));

        }
      } else if (time > a.getStart() && time < a.getStop()) {
        // When the client want to modify that is in between the motion
        //TODO delete the command object and replace with split interval
        if (x != null && y != null) {
          int fromX = a.getPosition()[0];
          int fromY = a.getPosition()[1];
          int toX = a.getPosition()[2];
          int toY = a.getPosition()[3];
          double endTime = a.getStop();
          double startTime = a.getStart();
          model.removeMotion(a);
          model.addMotion(new Move(fromX, fromY, x, y, startTime, time, this.clock));
          model.addMotion(new Move(x, y, toX, toY, time, endTime, this.clock));
        }

        if (width != null && height != null) {
          int fromWidth = a.getDimension()[0];
          int fromHeight = a.getDimension()[1];
          int toWidth = a.getDimension()[2];
          int toHeight = a.getDimension()[3];
          double startTime = a.getStart();
          double endTime = a.getStop();
          model.removeMotion(a);
          model.addMotion(
              new ChangeSize(fromHeight, fromWidth, width, height, startTime, time, this.clock));
          model.addMotion(
              new ChangeSize(width, height, toWidth, toHeight, time, endTime, this.clock));

        }

        if (r != null && g != null && b != null) {
          int fromR = a.getColor()[0];
          int fromG = a.getColor()[1];
          int fromB = a.getColor()[2];
          int toR = a.getColor()[3];
          int toG = a.getColor()[4];
          int toB = a.getColor()[5];
          double startTime = a.getStart();
          double endTime = a.getStop();
          model.removeMotion(a);
          model.addMotion(
              new ChangeColor(fromR, fromG, fromB, r, g, b, startTime, time, this.clock));
          model.addMotion(
              new ChangeColor(r, g, b, toR, toG, toB, time, endTime, this.clock));

        }
      }
    }
  }


  @Override
  public void removeKeyFrame(ShapesModel model, Integer time) {
    this.removeMoveKeyFrame(model,time);
    this.removeSizeKeyFrame(model, time);
    this.removeColorKeyFrame(model, time);
  }

  private void removeMoveKeyFrame(ShapesModel model, Integer time) {
    for (Move m : model.getMoveCommands()) {
      // Client remove the start of the animation
      //TODO find the endTime that is equal to time and merge them
      if (Math.abs(time - m.getStart()) < 0.01) {
        int fromX = 0;
        int fromY = 0;
        int toX = m.getPosition()[2];
        int toY = m.getPosition()[3];
        double startTime = 0;
        double endTime = m.getStop();
        model.removeMotion(m);

        for (Move t : model.getMoveCommands()) {
          if (Math.abs(time - t.getStop()) < 0.01) {
            fromX = t.getPosition()[0];
            fromY = t.getPosition()[1];
            startTime = t.getStart();
            model.removeMotion(t);
          }
        }

        model.addMotion(new Move(fromX,fromY,toX,toY,startTime,endTime,this.clock));
      }
    }
  }

  private void removeSizeKeyFrame(ShapesModel model, Integer time) {
    for (ChangeSize s : model.getSizeCommands()) {
      // Client remove the start of the animation
      //TODO find the endTime that is equal to time and merge them
      if (Math.abs(time - s.getStart()) < 0.01) {
        int fromWidth = 0;
        int fromHeight = 0;
        int toWidth = s.getDimension()[2];
        int toHeight = s.getDimension()[3];
        double startTime = 0;
        double endTime = s.getStop();
        model.removeMotion(s);

        for (ChangeSize t : model.getSizeCommands()) {
          if (Math.abs(time - t.getStop()) < 0.01) {
            fromWidth = t.getDimension()[0];
            fromHeight = t.getDimension()[1];
            startTime = t.getStart();
            model.removeMotion(t);
          }
        }

        model.addMotion(new ChangeSize(fromWidth,fromHeight,toWidth,toHeight,startTime,endTime,this.clock));
      }
    }
  }

  private void removeColorKeyFrame(ShapesModel model, Integer time) {
    for (ChangeColor c : model.getColorCommands()) {
      // Client remove the start of the animation
      //TODO find the endTime that is equal to time and merge them
      if (Math.abs(time - c.getStart()) < 0.01) {
        int fromR = 0;
        int fromG = 0;
        int fromB = 0;
        int toR = c.getColor()[3];
        int toG = c.getColor()[4];
        int toB = c.getColor()[5];
        double startTime = 0;
        double endTime = c.getStop();
        model.removeMotion(c);

        for (ChangeColor t : model.getColorCommands()) {
          if (Math.abs(time - t.getStop()) < 0.01) {
            fromR = t.getColor()[0];
            fromG = t.getColor()[1];
            fromB = t.getColor()[2];
            startTime = t.getStart();
            model.removeMotion(t);
          }
        }

        model.addMotion(new ChangeColor(fromR,fromG,fromB,toR,toG, toB,startTime,endTime,this.clock));
      }
    }
  }



  @Override
  public void updateClock() {
    this.clock++;
  }

  @Override
  public double getClock() {
    return this.clock;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getLeftMost() {
    return this.leftMost;
  }

  @Override
  public int getTopMost() {
    return this.topMost;
  }

  /**
   * Builder Pattern for construct the animation.
   */
  public static final class Builder implements AnimationBuilder<AnimatorModel> {

    private int height;
    private int width;
    private int leftMost;
    private int topMost;
    private Map<String, ShapesModel> shapes;

    /**
     * Represent the Builder that parse in the given txt file.
     *
     * @param stringShapesModelHashMap represent the list of Shapes with its name as a key
     */
    public Builder(HashMap<String, ShapesModel> stringShapesModelHashMap) {
      this.height = 500;
      this.width = 500;
      this.leftMost = 0;
      this.topMost = 0;
      this.shapes = stringShapesModelHashMap;
    }


    @Override
    public AnimatorModel build() {
      return new AnimatorModelImpl(height, width, leftMost, topMost,
          (HashMap<String, ShapesModel>) shapes);
    }

    @Override
    public AnimationBuilder<AnimatorModel> setBounds(int x, int y, int width, int height) {
      this.height = height;
      this.width = width;
      this.leftMost = x;
      this.topMost = y;
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> declareShape(String name, String type) {
      switch (type.toLowerCase()) {
        case "ellipse":
          this.shapes.put(name, new Oval(name,
              new CartPosition(0, 0), new RGBColor(0, 0, 0),
              new Dimension(0, 0), this.build().getClock()));
          break;
        case "rectangle":
          this.shapes.put(name, new Rectangle(name,
              new CartPosition(0, 0), new RGBColor(0, 0, 0),
              new Dimension(0, 0), this.build().getClock()));
          break;
        default:
          throw new IllegalArgumentException("Shapes cannot be created with the given parameter");
      }
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1,
        int r1, int g1, int b1,
        int t2, int x2, int y2, int w2, int h2,
        int r2, int g2, int b2) {
      AnimatorCommand move = new Move(x1, y1, x2, y2, t1, t2, this.build().getClock());
      AnimatorCommand changeColor = new ChangeColor(r1, g1, b1, r2, g2, b2, t1, t2,
          this.build().getClock());
      AnimatorCommand changeSize = new ChangeSize(w1, h1, w2, h2, t1, t2, this.build().getClock());
      this.shapes.get(name).addMotion(move);
      this.shapes.get(name).addMotion(changeColor);
      this.shapes.get(name).addMotion(changeSize);
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> addKeyframe(String name, int t, int x, int y, int w,
        int h, int r, int g, int b) {
      return null;
    }
  }
}
