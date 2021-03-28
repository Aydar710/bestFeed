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

    api(project(Modules.data))

    // Hilt
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.androidCompilerKapt)
    implementation(Libs.Hilt.lifecycleViewModel)
    kapt(Libs.Hilt.hiltCompilerKapt)

    // Retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.Retrofit.loggingInterceptor)

}