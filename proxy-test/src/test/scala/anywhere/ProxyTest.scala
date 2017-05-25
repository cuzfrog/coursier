package anywhere

import coursier._
/**
  * Created by cuz on 5/25/17.
  */
object ProxyTest extends App{
  val start = Resolution(
    Set(
      Dependency(
        Module("org.typelevel", "cats-core_2.12"), "0.6.0"
      )
    )
  )
  val fetch = Fetch.from(Seq(MavenRepository("https://repo1.maven.org/maven2")), Cache.fetch())

  System.setProperty("https.proxyHost","localhost")
  System.setProperty("https.proxyPort","808")

  val resolution = start.process.run(fetch).run
}
