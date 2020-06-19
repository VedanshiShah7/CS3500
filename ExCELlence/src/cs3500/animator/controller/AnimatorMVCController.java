package cs3500.animator.controller;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.commands.AnimatorCommand;
import cs3500.animator.view.AnimatorView;

import cs3500.animator.view.IEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Represent the Controller that receive input from view and manage animator operation. This class
 * represents the implementation of the AnimationController interface.
 */
public class AnimatorMVCController implements AnimatorController, ActionListener {

  private AnimatorModel model;
  private IEditorView view;

  /**
   * Represent the Default constructor for the Animator MVC model.
   *
   * @param model represent the model of the Animator Excellence
   * @param view  represent the view of the animator Excellence
   */
  public AnimatorMVCController(AnimatorModel model, IEditorView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public String processCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    AnimatorCommand cmd = null;
    //TODO switch statement of given user action.
    return this.model.toString(); // Placeholder for style grader
  }

  @Override
  public void executeCommand() {
    this.view.setCommandListener(this);
    this.view.makeVisible();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    switch (command) {
      case "start":
        this.view.startTimer();
        break;
      case "pause":
        this.view.pausedTimer();
        break;
      case "resume":
        this.view.startTimer();
        break;
      case "restart":
        this.view.restartTimer();
        break;
      case "enable_looping":
        break;
      case "disable_looping":
        break;
      case "increase_speed":
        break;
      case "decrease_speed":
        break;
      default:
        throw new IllegalArgumentException("Invalid Command is called");
    }
  }

}
