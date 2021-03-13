import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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

    implementation(Libs.Navigation.ui)
    implementation(Libs.Navigation.fragment)
    implementation(Libs.Layout.constraintLayout)

    implementation(Libs.Google.play)
    implementation(Libs.Google.material)

//    implementation(Libs.viewBindingPropertyDelegate)
}