import static org.junit.Assert.assertEquals;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.AnimatorModelImpl;
import cs3500.animator.model.shapes.ShapesModel;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.AnimationSVGView;
import cs3500.animator.view.AnimatorView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

/**
 * Represent the test for SVG representation.
 */
public class AnimationSVGViewTest {

  AnimatorModel model;
  AnimatorView view;

  @Before
  public void setup() throws FileNotFoundException {
    this.model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
        new AnimatorModelImpl.Builder(new HashMap<String, ShapesModel>()));

    this.view = new AnimationSVGView(this.model, 1);
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
  public void testSVGView() {
    this.view.createAnimationOutput();
    assertEquals(
        "<svg viewBox=\"145 50 410 220\" xmlns=\"http://www.w3.org/2000/svg\">"
            + "<rect id=\"disk3\" x=\"0.0\" y=\"0.0\" width=\"0\" height=\"0\" "
            + "fill=\"rgb(0.0,0.0,0.0)\" visibility=\"visible\">\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"145\" to=\"145\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"120000.0ms\" "
            + "attributeName=\"x\" from=\"145\" to=\"145\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"120000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"120000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"120000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"120000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"145\" to=\"145\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"131000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"145\" to=\"145\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"131000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"131000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"131000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"131000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"132000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"145\" to=\"445\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"132000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"132000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"132000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"132000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"142000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"445\" to=\"445\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"142000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"142000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"142000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"142000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"143000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"445\" to=\"445\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"143000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"143000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(11,45,175)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"143000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"143000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"x\" from=\"445\" to=\"445\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"161000.0ms\" dur=\"141000.0ms\" "
            + "attributeName=\"x\" from=\"445\" to=\"445\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"161000.0ms\" dur=\"141000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"161000.0ms\" dur=\"141000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,255,0)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"161000.0ms\" dur=\"141000.0ms\" "
            + "attributeName=\"width\" from=\"110\" to=\"110\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"161000.0ms\" dur=\"141000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "</rect>\n" +
            "<rect id=\"disk1\" x=\"0.0\" y=\"0.0\" width=\"0\" height=\"0\" "
            + "fill=\"rgb(0.0,0.0,0.0)\" visibility=\"visible\">\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"180\" to=\"180\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"24000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"24000.0ms\" "
            + "attributeName=\"y\" from=\"180\" to=\"180\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"24000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"24000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"24000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"25000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"25000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"180\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"25000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"25000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"25000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"35000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"35000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"35000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"35000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"35000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"36000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"36000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"36000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"36000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"36000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"46000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"46000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"46000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"46000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"46000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"47000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"47000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"47000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"47000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"47000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"99000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"99000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"99000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"99000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"99000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"100000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"340\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"100000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"100000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"100000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"100000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"110000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"340\" to=\"340\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"110000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"110000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"110000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"110000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"111000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"340\" to=\"340\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"111000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"111000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"111000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"111000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"x\" from=\"340\" to=\"340\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"340\" to=\"340\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"163000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"340\" to=\"340\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"163000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"163000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"163000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"163000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"164000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"340\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"164000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"164000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"164000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"164000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"174000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"174000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"174000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"174000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"174000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"175000.0ms\" dur=\"10000.0ms\""
            + " attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"175000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"175000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"175000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"175000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"32000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"227000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"190\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"227000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"227000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"227000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"227000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"228000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"228000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"228000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"228000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"228000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"238000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"238000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"238000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"238000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"238000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"239000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"239000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"180\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"239000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,49,90)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"239000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"239000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"249000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"249000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"y\" from=\"180\" to=\"180\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"249000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"249000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"249000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"257000.0ms\" dur=\"45000.0ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"490\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"257000.0ms\" dur=\"45000.0ms\" "
            + "attributeName=\"y\" from=\"180\" to=\"180\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"257000.0ms\" dur=\"45000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,255,0)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"257000.0ms\" dur=\"45000.0ms\" "
            + "attributeName=\"width\" from=\"20\" to=\"20\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"257000.0ms\" dur=\"45000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "</rect>\n" +
            "<rect id=\"disk2\" x=\"0.0\" y=\"0.0\" width=\"0\" height=\"0\" "
            + "fill=\"rgb(0.0,0.0,0.0)\" visibility=\"visible\">\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"167\" to=\"167\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"56000.0ms\" "
            + "attributeName=\"x\" from=\"167\" to=\"167\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"56000.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"56000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"56000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"56000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"167\" to=\"167\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"67000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"167\" to=\"167\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"67000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"67000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"67000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"67000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"68000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"167\" to=\"317\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"68000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"68000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"68000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"68000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"78000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"317\" to=\"317\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"78000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"78000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"78000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"78000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"79000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"317\" to=\"317\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"79000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"79000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"79000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"79000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"96000.0ms\" "
            + "attributeName=\"x\" from=\"317\" to=\"317\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"96000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"240\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"96000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"96000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"96000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"317\" to=\"317\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"195000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"317\" to=\"317\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"195000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"195000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"195000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"195000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"196000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"317\" to=\"467\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"196000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"196000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"196000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"196000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"206000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"x\" from=\"467\" to=\"467\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"206000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"50\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"206000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"206000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"206000.0ms\" dur=\"1000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"207000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"467\" to=\"467\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"207000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"207000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(6,247,41)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"207000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"207000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"x\" from=\"467\" to=\"467\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"225000.0ms\" dur=\"77000.0ms\" "
            + "attributeName=\"x\" from=\"467\" to=\"467\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"225000.0ms\" dur=\"77000.0ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"210\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"225000.0ms\" dur=\"77000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,255,0)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"225000.0ms\" dur=\"77000.0ms\" "
            + "attributeName=\"width\" from=\"65\" to=\"65\" fill=\"freeze\" />\n"
            +
            "<animate attributeType=\"xml\" begin=\"225000.0ms\" dur=\"77000.0ms\" "
            + "attributeName=\"height\" from=\"30\" to=\"30\" fill=\"freeze\" />\n"
            +
            "</rect>\n" +
            "</svg>", this.view.getOutput().toString());
  }
}