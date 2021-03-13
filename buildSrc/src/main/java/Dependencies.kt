object DefaultConfig {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.2"

    const val applicationId = "com.aydar.bestfeed"

    const val minSdkVersion = 21
    const val targetSdkVersion = 30

    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Modules {
    const val featureMain = ":feature-main"
}

object Libs {

    const val viewBindingPropertyDelegate =
        "com.github.kirich1409:ViewBindingPropertyDelegate:1.2.2"

    object Layout {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    }

    object Navigation {
        private const val version = "2.3.0"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
    }

    object Lifecycle {
        private const val version = "2.3.0-beta01"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    }

    object Google {
        const val services = "com.google.gms:google-services:4.3.4"
        const val material = "com.google.android.material:material:1.3.0-alpha03"
        const val play = "com.google.android.play:core-ktx:1.8.1"
        const val playCore = "com.google.android.play:core:1.8.2"

        object Firebase {
            const val messaging = "com.google.firebase:firebase-messaging:20.3.0"
            const val analytics = "com.google.firebase:firebase-analytics-ktx:17.6.0"
            const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx:17.2.2"
            const val crashlyticsGradlePlugin =
                "com.google.firebase:firebase-crashlytics-gradle:2.3.0"
        }
    }
}