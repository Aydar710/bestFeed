plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("com.google.gms.google-services")
}

android {

    compileSdkVersion(DefaultConfig.compileSdkVersion)
    buildToolsVersion(DefaultConfig.buildToolsVersion)

    defaultConfig {

        applicationId = DefaultConfig.applicationId

        minSdkVersion(DefaultConfig.minSdkVersion)
        targetSdkVersion(DefaultConfig.targetSdkVersion)

        versionCode = DefaultConfig.versionCode
        versionName = DefaultConfig.versionName

        testInstrumentationRunner = DefaultConfig.testInstrumentationRunner
    }


    signingConfigs {
        create("release") {

        }
    }

    buildTypes {
        getByName("release") {
        }

        getByName("debug") {
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    kotlinOptions.jvmTarget = "1.8"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(project(Modules.featureMain))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(Libs.Navigation.ui)
    implementation(Libs.Navigation.fragment)
    implementation(Libs.Layout.constraintLayout)

    implementation(Libs.Google.play)
    implementation(Libs.Google.material)

    // Hilt
    implementation(Libs.Hilt.hilt)
    implementation("com.google.firebase:firebase-messaging:20.1.0")
    kapt(Libs.Hilt.androidCompilerKapt)
    kapt(Libs.Hilt.hiltCompilerKapt)

    // Retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.Retrofit.loggingInterceptor)

    implementation(Libs.vkSdk)

    // Room
    implementation(Libs.Room.room)
    implementation(Libs.Room.extAndCoroutines)
    kapt(Libs.Room.annotationProcessor)
    implementation(Libs.Room.common)
    // end Room

//    implementation(Libs.viewBindingPropertyDelegate)

}