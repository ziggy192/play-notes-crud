
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nghialq/IdeaProjects/play-notes-crud/conf/routes
// @DATE:Wed Jun 19 16:58:51 ICT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseNotesController NotesController = new controllers.ReverseNotesController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseNotesController NotesController = new controllers.javascript.ReverseNotesController(RoutesPrefix.byNamePrefix());
  }

}
