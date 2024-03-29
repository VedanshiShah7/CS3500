import static org.junit.Assert.assertEquals;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.AnimatorModelImpl.Builder;
import cs3500.animator.model.shapes.ShapesModel;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.AnimationTextView;
import cs3500.animator.view.AnimatorView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

/**
 * Represent the Text representation of the animator.
 */
public class AnimationTextViewTest {

  AnimatorModel model;
  AnimatorView view;

  @Before
  public void setup() throws FileNotFoundException {
    this.model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
        new Builder(new HashMap<String, ShapesModel>()));

    this.view = new AnimationTextView(this.model);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void makeVisible() {
    this.view.makeVisible();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void refresh() {
    this.view.refresh();
  }

  @Test
  public void testTextView() {
    this.view.createAnimationOutput();
    assertEquals("canvas: 145 50 410 220\n"
            + "Shape disk3 Rectangle \n"
            + "Motion disk3 0 0 0 0 0 0 0 0  1 145 240 110 30 11 45 175\n"
            + "Motion disk3 1 145 240 110 30 11 45 175  121 145 240 110 30 11 45 175\n"
            + "Motion disk3 121 145 240 110 30 11 45 175  131 145 50 110 30 11 45 175\n"
            + "Motion disk3 131 145 50 110 30 11 45 175  132 145 50 110 30 11 45 175\n"
            + "Motion disk3 132 145 50 110 30 11 45 175  142 445 50 110 30 11 45 175\n"
            + "Motion disk3 142 445 50 110 30 11 45 175  143 445 50 110 30 11 45 175\n"
            + "Motion disk3 143 445 50 110 30 11 45 175  153 445 240 110 30 11 45 175\n"
            + "Motion disk3 153 445 240 110 30 11 45 175  161 445 240 110 30 0 255 0\n"
            + "Motion disk3 161 445 240 110 30 0 255 0  302 445 240 110 30 0 255 0\n"
            + "Shape disk1 Rectangle \n"
            + "Motion disk1 0 0 0 0 0 0 0 0  1 190 180 20 30 0 49 90\n"
            + "Motion disk1 1 190 180 20 30 0 49 90  25 190 180 20 30 0 49 90\n"
            + "Motion disk1 25 190 180 20 30 0 49 90  35 190 50 20 30 0 49 90\n"
            + "Motion disk1 35 190 50 20 30 0 49 90  36 190 50 20 30 0 49 90\n"
            + "Motion disk1 36 190 50 20 30 0 49 90  46 490 50 20 30 0 49 90\n"
            + "Motion disk1 46 490 50 20 30 0 49 90  47 490 50 20 30 0 49 90\n"
            + "Motion disk1 47 490 50 20 30 0 49 90  57 490 240 20 30 0 49 90\n"
            + "Motion disk1 57 490 240 20 30 0 49 90  89 490 240 20 30 0 49 90\n"
            + "Motion disk1 89 490 240 20 30 0 49 90  99 490 50 20 30 0 49 90\n"
            + "Motion disk1 99 490 50 20 30 0 49 90  100 490 50 20 30 0 49 90\n"
            + "Motion disk1 100 490 50 20 30 0 49 90  110 340 50 20 30 0 49 90\n"
            + "Motion disk1 110 340 50 20 30 0 49 90  111 340 50 20 30 0 49 90\n"
            + "Motion disk1 111 340 50 20 30 0 49 90  121 340 210 20 30 0 49 90\n"
            + "Motion disk1 121 340 210 20 30 0 49 90  153 340 210 20 30 0 49 90\n"
            + "Motion disk1 153 340 210 20 30 0 49 90  163 340 50 20 30 0 49 90\n"
            + "Motion disk1 163 340 50 20 30 0 49 90  164 340 50 20 30 0 49 90\n"
            + "Motion disk1 164 340 50 20 30 0 49 90  174 190 50 20 30 0 49 90\n"
            + "Motion disk1 174 190 50 20 30 0 49 90  175 190 50 20 30 0 49 90\n"
            + "Motion disk1 175 190 50 20 30 0 49 90  185 190 240 20 30 0 49 90\n"
            + "Motion disk1 185 190 240 20 30 0 49 90  217 190 240 20 30 0 49 90\n"
            + "Motion disk1 217 190 240 20 30 0 49 90  227 190 50 20 30 0 49 90\n"
            + "Motion disk1 227 190 50 20 30 0 49 90  228 190 50 20 30 0 49 90\n"
            + "Motion disk1 228 190 50 20 30 0 49 90  238 490 50 20 30 0 49 90\n"
            + "Motion disk1 238 490 50 20 30 0 49 90  239 490 50 20 30 0 49 90\n"
            + "Motion disk1 239 490 50 20 30 0 49 90  249 490 180 20 30 0 49 90\n"
            + "Motion disk1 249 490 180 20 30 0 49 90  257 490 180 20 30 0 255 0\n"
            + "Motion disk1 257 490 180 20 30 0 255 0  302 490 180 20 30 0 255 0\n"
            + "Shape disk2 Rectangle \n"
            + "Motion disk2 0 0 0 0 0 0 0 0  1 167 210 65 30 6 247 41\n"
            + "Motion disk2 1 167 210 65 30 6 247 41  57 167 210 65 30 6 247 41\n"
            + "Motion disk2 57 167 210 65 30 6 247 41  67 167 50 65 30 6 247 41\n"
            + "Motion disk2 67 167 50 65 30 6 247 41  68 167 50 65 30 6 247 41\n"
            + "Motion disk2 68 167 50 65 30 6 247 41  78 317 50 65 30 6 247 41\n"
            + "Motion disk2 78 317 50 65 30 6 247 41  79 317 50 65 30 6 247 41\n"
            + "Motion disk2 79 317 50 65 30 6 247 41  89 317 240 65 30 6 247 41\n"
            + "Motion disk2 89 317 240 65 30 6 247 41  185 317 240 65 30 6 247 41\n"
            + "Motion disk2 185 317 240 65 30 6 247 41  195 317 50 65 30 6 247 41\n"
            + "Motion disk2 195 317 50 65 30 6 247 41  196 317 50 65 30 6 247 41\n"
            + "Motion disk2 196 317 50 65 30 6 247 41  206 467 50 65 30 6 247 41\n"
            + "Motion disk2 206 467 50 65 30 6 247 41  207 467 50 65 30 6 247 41\n"
            + "Motion disk2 207 467 50 65 30 6 247 41  217 467 210 65 30 6 247 41\n"
            + "Motion disk2 217 467 210 65 30 6 247 41  225 467 210 65 30 0 255 0\n"
            + "Motion disk2 225 467 210 65 30 0 255 0  302 467 210 65 30 0 255 0\n"
        , this.view.getOutput().toString());
  }


}