
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nghialq/IdeaProjects/play-notes-crud/conf/routes
// @DATE:Wed Jun 19 16:58:51 ICT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:7
  class ReverseNotesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def addNote(request:Request): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "v1/notes" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
    // @LINE:7
    def getAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "v1/notes")
    }
  
    // @LINE:11
    def deleteNote(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "v1/notes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:10
    def getNoteById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "v1/notes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:9
    def updateNote(id:Integer, request:Request): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "v1/notes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
  }


}
