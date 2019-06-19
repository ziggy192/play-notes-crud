
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nghialq/IdeaProjects/play-notes-crud/conf/routes
// @DATE:Wed Jun 19 16:58:51 ICT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseNotesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def addNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.addNote",
      """
        function(request0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/notes" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
        }
      """
    )
  
    // @LINE:7
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/notes"})
        }
      """
    )
  
    // @LINE:11
    def deleteNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.deleteNote",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/notes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:10
    def getNoteById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.getNoteById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/notes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def updateNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.updateNote",
      """
        function(id0,request1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/notes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request1)])})
        }
      """
    )
  
  }


}
