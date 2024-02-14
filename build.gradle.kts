import korlibs.korge.gradle.*

plugins {
  alias(libs.plugins.korge)
//  idea
}

kotlin {
  jvmToolchain(17)
}


//idea {
//  module {
//    isDownloadJavadoc = true
//    isDownloadSources = true
//  }
//}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(17)
  }
}



korge {
  id = "com.sample.demo"
  jvmMainClassName = "MainKt"
  // To enable all targets at once

  //targetAll()

// To enable targets based on properties/environment variables
  //targetDefault()

// To selectively enable targets

  targetJvm()
  targetJs()
  targetWasm()
//	targetDesktop()
//	targetIos()
//	targetAndroid()

  serializationJson()
}


dependencies {
  add("commonMainApi", project(":deps"))

}

