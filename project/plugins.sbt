// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype repository" at "https://oss.sonatype.org/service/local/repositories/releases/content/"


addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")