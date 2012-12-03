package me.elrod.RefHeap

import dispatch._
import org.json4s._
import org.json4s.jackson.JsonMethods._

/** A client to the RefHeap.com API. */
class RefHeapClient(
  username: String = "",
  token: String = "",
  apiURL: String = "https://gentle-brook-6111.herokuapp.com/api") {

  implicit val formats = DefaultFormats

  /** Paste text to RefHeap.
    *
    * This method does not block. Instead, it returns a [[dispatch.Promise]
    * which contains a [[RefHeapPaste]]. Using this method should go something
    * like this:
    *
    * {{{
    * val res = client.paste(RefHeapPaste("PHP", true, "<?php echo 'hello!';"))
    * res.completeOption // An Option[RefHeapPaste], if successful.
    * }}}
    *
    * @param paste The paste object to paste data from.
    * @return A [[dispatch.Promise]] containing the returned [[RefHeapPaste]].
    */
  def paste(paste: RefHeapPaste) = {
    val request = url(apiURL) / "paste" << Map(
      "token" -> token,
      "username" -> username,
      "language" -> paste.language,
      "private" -> paste.`private`.toString,
      "contents" -> paste.contents
    )
    val x = Http(request > as.json4s.Json)
    for (c <- x) yield c.extract[RefHeapPaste]
  }
}
