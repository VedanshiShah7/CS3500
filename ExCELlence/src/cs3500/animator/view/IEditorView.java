package cs3500.animator.view;

/**
 * Manage Operation for the Editor View while maintain backward compatibility with the AnimatorView.
 */
public interface IEditorView extends AnimatorView {

  void startTimer();

  void pausedTimer();

  void restartTimer();
  

}
