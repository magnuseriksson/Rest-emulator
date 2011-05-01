package controllers;

import play.Play;
import play.mvc.Controller;

import java.io.File;
import java.io.IOException;

/**
 *   Base class containing utility methods.
 */
public class BaseController extends Controller {

  /**
   *  
   * @return the dataset url configured in application.conf
   */
  protected static String getBasePath() {
    return "datasets/" + Play.configuration.getProperty("emulator.dataset", "dev");
  }
}
