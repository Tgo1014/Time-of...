object BuildPlugins {
//    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
//    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

object Deps {

    object Room {
        private val version = "2.5.0-beta02"
        val runtime = "androidx.room:room-ktx:$version"
        val processor = "androidx.room:room-compiler:$version"
    }

    object Compose {
        val version = "1.4.0-alpha02"
        val composeUi = "androidx.compose.ui:ui:$version"
        val material3 = "androidx.compose.material3:material3:1.0.0-alpha01"
        val preview = "androidx.compose.ui:ui-tooling-preview:$version"
        val composeTesting = "androidx.compose.ui:ui-test-junit4:$version"
        val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        val uiTest = "androidx.compose.ui:ui-test-manifest:$version"

    }

//    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
//    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
//    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
//    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
//    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
//    val junit by lazy { "junit:junit:${Versions.jUnit}" }

}