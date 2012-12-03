package me.elrod.RefHeap

case class RefHeapPaste(
  val language: String,
  val `private`: Boolean,
  val contents: String,
  val lines: Int = 0,
  val date: String = "", // TODO: Make this a DateTime?
  val user: String = "") {

  val isPrivate = `private`

  override def toString = "%s %s Paste".format(
    `private` match {
      case true => "Private"
      case false => "Public"
    },
    language)
}
