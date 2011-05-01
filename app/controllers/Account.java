package controllers;

import java.io.File;

public class Account extends BaseController {

  private static String getDataSet(String service) {
    return getBasePath() + "/" + service + "/";
  }

  public static void index(String id) throws Exception {
    renderBinary(new File(getDataSet("account") + id + ".xml"), "UTF-8");
  }


  /**
   * Emulates the create user service , if user 1111 . ,then it already exists and an error is return.
   *
   * @param id:userid
   */
  public static void create(String id) {

    // emulating that a user already exist , and then return HttpStatus 500
    if ("1111".equals(id)) {
      response.status = 500;
      renderText("error.user.alreadyexist");
    }
  }


  /**
   * emulates the withdraw service , this is a POST , configured in /conf/routes
   * its possible to validate the incoming data by viewing the body
   *
   * @param id:userid
   */
  public static void withdraw(String id) {
    String body = (String) renderArgs.get("body");
    // validate the posted xml
    //

    renderBinary(new File(getDataSet("withdraw") + id + ".xml"), "UTF-8");
  }
}
