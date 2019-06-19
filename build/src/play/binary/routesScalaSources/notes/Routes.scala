
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nghialq/IdeaProjects/play-notes-crud/conf/notes.routes
// @DATE:Wed Jun 19 16:58:51 ICT 2019

package notes

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler
  ) = this(errorHandler, "/")

  def withPrefix(prefix: String): Routes = {
    notes.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}



  def routes: PartialFunction[RequestHeader, Handler] = {
  
    Map.empty
  }
}
