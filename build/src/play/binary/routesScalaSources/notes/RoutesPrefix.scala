
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nghialq/IdeaProjects/play-notes-crud/conf/notes.routes
// @DATE:Wed Jun 19 16:58:51 ICT 2019


package notes {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
