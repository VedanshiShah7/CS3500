package cs3500.animator.controller;

/**
 * The controller interface for the Excellence animator. Represents operations offered by the
 * controller. Giving directions to control the model and the view. Used to run the animation. The
 * functions here have been designed to give control to the controller, and the primary operation
 * for the controller to function (process a shape command)
 */
public interface AnimatorController {

  /**
   * Process each given command string which would invoke Model function.
   *
   * @param command represent the user given commands
   * @return model status or error message.
   */
  String processCommand(String command);

  /**
   * Start the Program. Gives control to the controller.
   */
  void executeCommand();

}
