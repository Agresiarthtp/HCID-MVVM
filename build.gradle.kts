// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra.apply {
        set("kotlin_version", "1.3.50")
        set("anko_version", "0.10.5")
    }
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}
tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
