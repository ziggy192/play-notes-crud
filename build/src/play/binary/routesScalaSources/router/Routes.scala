
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nghialq/IdeaProjects/play-notes-crud/conf/routes
// @DATE:Wed Jun 19 16:58:51 ICT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:7
  NotesController_2: controllers.NotesController,
  // @LINE:13
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:7
    NotesController_2: controllers.NotesController,
    // @LINE:13
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, NotesController_2, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, NotesController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/notes""", """controllers.NotesController.getAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/notes""", """controllers.NotesController.addNote(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/notes/""" + "$" + """id<[^/]+>""", """controllers.NotesController.updateNote(id:Integer, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/notes/""" + "$" + """id<[^/]+>""", """controllers.NotesController.getNoteById(id:Integer)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/notes/""" + "$" + """id<[^/]+>""", """controllers.NotesController.deleteNote(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_NotesController_getAll1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/notes")))
  )
  private[this] lazy val controllers_NotesController_getAll1_invoker = createInvoker(
    NotesController_2.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """v1/notes""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_NotesController_addNote2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/notes")))
  )
  private[this] lazy val controllers_NotesController_addNote2_invoker = createInvoker(
    NotesController_2.addNote(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "addNote",
      Seq(classOf[Request]),
      "POST",
      this.prefix + """v1/notes""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_NotesController_updateNote3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/notes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_NotesController_updateNote3_invoker = createInvoker(
    NotesController_2.updateNote(fakeValue[Integer], fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "updateNote",
      Seq(classOf[Integer], classOf[Request]),
      "PUT",
      this.prefix + """v1/notes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_NotesController_getNoteById4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/notes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_NotesController_getNoteById4_invoker = createInvoker(
    NotesController_2.getNoteById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "getNoteById",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """v1/notes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_NotesController_deleteNote5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/notes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_NotesController_deleteNote5_invoker = createInvoker(
    NotesController_2.deleteNote(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "deleteNote",
      Seq(classOf[Integer]),
      "DELETE",
      this.prefix + """v1/notes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_NotesController_getAll1_route(params) =>
      call { 
        controllers_NotesController_getAll1_invoker.call(NotesController_2.getAll)
      }
  
    // @LINE:8
    case controllers_NotesController_addNote2_route(params) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_NotesController_addNote2_invoker.call(NotesController_2.addNote(request))
      }
  
    // @LINE:9
    case controllers_NotesController_updateNote3_route(params) =>
      call(params.fromPath[Integer]("id", None), params.fromQuery[Request]("request", None)) { (id, request) =>
        controllers_NotesController_updateNote3_invoker.call(NotesController_2.updateNote(id, request))
      }
  
    // @LINE:10
    case controllers_NotesController_getNoteById4_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_NotesController_getNoteById4_invoker.call(NotesController_2.getNoteById(id))
      }
  
    // @LINE:11
    case controllers_NotesController_deleteNote5_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_NotesController_deleteNote5_invoker.call(NotesController_2.deleteNote(id))
      }
  
    // @LINE:13
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
