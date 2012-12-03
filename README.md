# Scala-RefHeap

A Scala client to [RefHeap](https://refheap.com/).

# Trying it out

If you're anxious to try this out (though I'm not sure why you would be - it's
not done yet :P), clone the git repo, and throw this in `sbt console`:

```scala
scala> import me.elrod.RefHeap.{RefHeapClient, RefHeapPaste}
import me.elrod.RefHeap.{RefHeapClient, RefHeapPaste}

scala> val paste = RefHeapPaste("PHP", true, "<?php echo 'hello!'; $foo = false;")
paste: me.elrod.RefHeap.RefHeapPaste = Private PHP Paste

scala> val x = new RefHeapClient("yourusername", "your-key").paste(paste)
x: dispatch.Promise[me.elrod.RefHeap.RefHeapPaste] = Promise(-incomplete-)
```

See the scaladoc for what to do with the result, but the gist of it is:

```scala
// This will be an Option[RefHeapPaste] which you can call .getOrElse on and handle appropriately.
x.completeOption
```

# License

MIT.
