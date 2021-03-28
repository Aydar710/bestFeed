plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
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

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments.put("room.incremental", "true")
            }
        }
    }
}

dependencies {

    // Retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.Retrofit.loggingInterceptor)
    // end Retrofit

    // Room
    implementation(Libs.Room.room)
    implementation(Libs.Room.extAndCoroutines)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    kapt(Libs.Room.annotationProcessor)
    implementation(Libs.Room.common)
    // end Room

    // Hilt
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.androidCompilerKapt)
    implementation(Libs.Hilt.lifecycleViewModel)
    kapt(Libs.Hilt.hiltCompilerKapt)
    // end Hilt
}