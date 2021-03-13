plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(DefaultConfig.compileSdkVersion)
    defaultConfig.minSdkVersion(DefaultConfig.minSdkVersion)
    buildFeatures.viewBinding = true
    kotlinOptions.jvmTarget = "1.8"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(Libs.Navigation.ui)
    implementation(Libs.Navigation.fragment)
    implementation(Libs.Layout.constraintLayout)

    implementation(Libs.Google.play)
    implementation(Libs.Google.material)

//    implementation(Libs.viewBindingPropertyDelegate)
}