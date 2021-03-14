plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(project(Modules.domain))

    implementation(Libs.Navigation.ui)
    implementation(Libs.Navigation.fragment)
    implementation(Libs.Layout.constraintLayout)

    implementation(Libs.Google.play)
    implementation(Libs.Google.material)

    // Hilt
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.androidCompilerKapt)
    implementation(Libs.Hilt.lifecycleViewModel)
    kapt(Libs.Hilt.hiltCompilerKapt)

    // Retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.Retrofit.loggingInterceptor)

    implementation(Libs.vkSdk)

    implementation(Libs.viewBindingPropertyDelegate)

    implementation(Libs.Glide.glide)
    implementation(Libs.Glide.glideAnnotationProcessor)
}