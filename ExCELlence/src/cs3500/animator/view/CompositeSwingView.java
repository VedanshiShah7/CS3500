package cs3500.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.function.Function;

import javax.swing.*;
import javax.swing.border.Border;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.shapes.CartPosition;
import cs3500.animator.model.shapes.Oval;
import cs3500.animator.model.shapes.RGBColor;
import cs3500.animator.model.shapes.ShapesModel;
import cs3500.animator.model.shapes.Rectangle;

public class CompositeSwingView extends JFrame implements ActionListener, IEditorView {

  private HashMap<Functionality, JButton> functionalityButton;
  private JComboBox functionOptions; // What is this for?

  //Keep track of the button on the Bottom of the Window
  private JPanel buttonPanel; // Should we remove this since we don't want every button to be inside one panel
  private JButton playButton;
  private JButton pauseButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JButton enableLoopingButton;
  private JButton disableLoopingButton;
  private JButton increaseSpeedButton;
  private JButton decreaseSpeedButton;

  // Left Sidebar button
  private JPanel shapePanel;
  private JButton createShapeButton;
  private JList listOfShapes; // Should we have this
  private JButton deleteShapeButton;
  private JButton submitNewShapes;

  // Right Sidebar
  private JPanel keyFramePanel;
  private JButton addKeyFrameButton;
  private JButton removeKeyFrameButton;
  private JButton modifyKeyFrameButton;

  private JLabel colorChooserDisplay;
  private JPanel newShapePanel;
  private JButton colorChooserButton;


  // Shape parameters
  private String shapeType;
  private String shape;
  private int xCor;
  private int yCor;
  private int width;
  private int height;
  private int rColor;
  private int gColor;
  private int bColor;

  private double time;
  private int toXCor;
  private int toYCor;
  private int toWidth;
  private int toHeight;
  private int toRColor;
  private int toGColor;
  private int toBColor;

  private AnimatorModel model;
  private AnimatorPanel mainPanel;
  private int tick;
  private double speed;
  private boolean looping;
  private JFrame f;

  public CompositeSwingView(AnimatorPanel panel, AnimatorModel model) {
    super();
    this.buttonPanel = new JPanel();
    this.keyFramePanel = new JPanel();
    this.shapePanel = new JPanel();
    this.mainPanel = panel;

    this.model = model;
    this.functionalityButton = new HashMap<>();
    this.functionOptions = new JComboBox<>();

    this.tick = 1;
    this.looping = true;
    this.setLayout(new BorderLayout());

    // Frame
    this.setTitle("Excellence Animator");
    this.setMinimumSize(panel.getMinimumSize());
    this.setMaximumSize(panel.getMaximumSize());
    this.setSize(getMaximumSize());
    this.setPreferredSize(getMaximumSize());
    this.setResizable(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // SCROLL DOESNT WORK

    // COMPONENTS
    initializeButton(playButton, "Play",
            Functionality.START.toString(), buttonPanel);
    initializeButton(pauseButton, "Pause",
            Functionality.PAUSE.toString(), buttonPanel);
    initializeButton(resumeButton, "Resume",
            Functionality.RESUME.toString(), buttonPanel);
    initializeButton(restartButton, "Restart",
            Functionality.RESTART.toString(), buttonPanel);
    initializeButton(enableLoopingButton, "Enable Looping",
            Functionality.ENABLE_LOOPING.toString(), buttonPanel);
    initializeButton(disableLoopingButton, "Disable Looping",
            Functionality.DISABLE_LOOPING.toString(), buttonPanel);
    initializeButton(increaseSpeedButton, "Increase Speed",
            Functionality.INCREASE_SPEED.toString(), buttonPanel);
    initializeButton(decreaseSpeedButton, "Decrease Speed",
            Functionality.DECREASE_SPEED.toString(), buttonPanel);

    // KEY FRAMES
    keyFramePanel.setLayout(new GridLayout(30, 1));
    initializeButton(addKeyFrameButton, "Add Key Frame",
            KeyframeEdit.ADD_KEYFRAME.toString(), keyFramePanel);
    initializeButton(removeKeyFrameButton, "Remove Key Frame",
            KeyframeEdit.REMOVE_KEYFRAME.toString(), keyFramePanel);
    initializeButton(modifyKeyFrameButton, "Modify Key Frame",
            KeyframeEdit.MODIFY_KEYFRAME.toString(), keyFramePanel);

    // SHAPES
    shapePanel.setLayout(new GridLayout(30, 1));
    initializeButton(createShapeButton, "Create Shape",
            KeyframeEdit.ADD_SHAPE.toString(), shapePanel);
    initializeButton(deleteShapeButton, "Delete Shape",
            KeyframeEdit.DELETE_SHAPE.toString(), shapePanel);

    this.add(buttonPanel, BorderLayout.SOUTH);
    this.add(keyFramePanel, BorderLayout.WEST);
    this.add(shapePanel, BorderLayout.EAST);
    this.add(mainPanel,BorderLayout.CENTER);

    mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    this.pack();
    f = new JFrame();
  }

  private void initializeButton(JButton button, String buttonText, String command, JPanel panel) {
    button = new JButton(buttonText);
    button.setActionCommand(command);
    button.addActionListener(this);
    panel.add(button);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    String action = actionEvent.getActionCommand();
    if (action.equals(Functionality.START.toString())) {
      if (model != null) {
        this.mainPanel.startAnimation();
      }
    } else if (action.equals(Functionality.PAUSE.toString())) {
      this.mainPanel.pauseAnimation();
    } else if (action.equals(Functionality.RESUME.toString())) {
      this.mainPanel.startAnimation();
    } else if (action.equals(Functionality.RESTART.toString())) {
      this.mainPanel.restartAnimation();
      this.tick = 0;
      refresh();
    } else if (action.equals(Functionality.ENABLE_LOOPING.toString())) {
      this.looping = true;
    } else if (action.equals(Functionality.DISABLE_LOOPING.toString())) {
      this.looping = false;
    } else if (action.equals(Functionality.INCREASE_SPEED.toString())) {
      this.speed++;
      // this.speed = Math.max(speed + 1, 1);
      // this.timer.setDelay((int) Math.max(1, (1.0 / speed * 1000.0)));
    } else if (action.equals(Functionality.DECREASE_SPEED.toString())) {
      this.speed--;
    } else if(action.equals(KeyframeEdit.ADD_SHAPE.toString())){

      try {
        getValues();

        RGBColor color = new RGBColor(rColor, gColor, bColor);
        Dimension dimension = new Dimension(width, height);
        CartPosition position = new CartPosition(xCor, yCor);
        ShapesModel s;
        if(shapeType.equals("Rectangle")){
          s = new Rectangle(shape, position, color, dimension, time);
          moveColorSize(s);
        } else if (shapeType.equals("Ellipse")) {
          s = new Oval(shape, position, color, dimension, time);
          moveColorSize(s);
        }
      }
      catch(IllegalArgumentException e){
        showErrorMessage(e.toString());
      }

    } else if (action.equals(KeyframeEdit.DELETE_SHAPE.toString())){
      shape = JOptionPane.showInputDialog(f, "Name of the shape to delete: ");
      try {
        model.removeShape(model.findShape(shape));
      } catch (IllegalArgumentException e){
        showErrorMessage(e.toString());
      }
    } else if (action.equals(KeyframeEdit.ADD_KEYFRAME.toString())){
      getValues();
      // there are two insertkeyFrames in the model... can you take a look at it.
      ShapesModel s = model.findShape(shape);
      model.insertKeyFrame(s, xCor, yCor, rColor, gColor, bColor,
              width, height, time);
    } else if (action.equals(KeyframeEdit.REMOVE_KEYFRAME.toString())){
      ShapesModel s = model.findShape(shape);
      model.removeKeyFrame(s, (int)time);
    } else if (action.equals(KeyframeEdit.MODIFY_KEYFRAME.toString())){
      ShapesModel s = model.findShape(shape);
      model.editKeyFrame(s, xCor, yCor, rColor, gColor, bColor,
              width, height, (int)time);
    } else {
      throw new IllegalStateException("Error! This is an invalid command. " +
              "This functionality is not offered.");
    }
  }


  private void getValues(){
    shapeType = JOptionPane.showInputDialog(f, "Shape Type: ");
    shape = JOptionPane.showInputDialog(f, "Shape Name: ");
    xCor = Integer.parseInt(JOptionPane.showInputDialog(f, "X Coordinate: "));
    yCor = Integer.parseInt(JOptionPane.showInputDialog(f, "Y Coordinate: "));
    width = Integer.parseInt(JOptionPane.showInputDialog(f, "Shape width: "));
    height = Integer.parseInt(JOptionPane.showInputDialog(f, "Shape height: "));
    rColor = Integer.parseInt(JOptionPane.showInputDialog(f, "Red value: "));
    gColor = Integer.parseInt(JOptionPane.showInputDialog(f, "Green value: "));
    bColor = Integer.parseInt(JOptionPane.showInputDialog(f, "Blue value: "));

    time = Double.parseDouble(JOptionPane.showInputDialog(f, "Time: "));
    toXCor = Integer.parseInt(JOptionPane.showInputDialog(f, "X Coordinate change to: "));
    toYCor = Integer.parseInt(JOptionPane.showInputDialog(f, "Y Coordinate change to: "));
    toWidth = Integer.parseInt(JOptionPane.showInputDialog(f, "Width change to: "));
    toHeight = Integer.parseInt(JOptionPane.showInputDialog(f, "Height change to: "));
    toRColor = Integer.parseInt(JOptionPane.showInputDialog(f, "Red Color change to: "));
    toGColor = Integer.parseInt(JOptionPane.showInputDialog(f, "Green Color change to: "));
    toBColor = Integer.parseInt(JOptionPane.showInputDialog(f, "Blue Color change to: "));
  }

  private void moveColorSize(ShapesModel s){
    model.addShape(s);
    model.moveShape(s, xCor, yCor, toXCor, toYCor, time, time+1);
    model.changeColor(s, rColor, gColor, bColor, toRColor, toGColor, toBColor, time, time+1);
    model.changeSize(s, width, height, toWidth, toHeight, time, time+1);
  }
  /**
   * Make the view visible to the client.
   */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  /**
   * Transmit an error message to the client, in case animation command is not properly set.
   *
   * @param error String that represent the error
   */
  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "ERROR!", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Refresh the view of the animation.
   */
  @Override
  public void refresh() {
    this.repaint();
  }

  /**
   * Provide the view with an action listener.
   *
   * @param actionEvent represent the actionListener
   */
  @Override
  public void setCommandListener(ActionListener actionEvent) {

  }

  /**
   * Writes a console output of the Animator Model.
   */
  @Override
  public void createAnimationOutput() {
    throw new UnsupportedOperationException("Invalid command for create animation");
  }

  /**
   * Gets the output of the Animator Output for text and SVG view.
   *
   * @return String the output to be written in the file output
   */
  @Override
  public Appendable getOutput() {
    throw new UnsupportedOperationException("Invalid command for create animation");
  }

  /**
   * Allow client to modify the tick speed for the animation.
   *
   * @param framePerSecond represent the number of tick per second
   */
  @Override
  public void changeTickSpeed(int framePerSecond) {
  }


  public void startTimer() {
    this.mainPanel.startAnimation();
  }

  public void pausedTimer() {
    this.mainPanel.pauseAnimation();
  }

  public void restartTimer() {
    this.mainPanel.restartAnimation();
  }

}
