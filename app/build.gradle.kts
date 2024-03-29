plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.mvvmsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvmsample"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //ksp
    dependencies {

        implementation(libs.androidx.room.runtime)
        implementation(libs.androidx.room.ktx)
//        annotationProcessor("androidx.room:room-compiler:$room_version")
//        // To use Kotlin Symbol Processing (KSP)
        ksp(libs.androidx.room.compiler)
//        // optional - Paging 3 Integration
        implementation(libs.androidx.room.paging)

        implementation(libs.kotlinx.coroutines.android)
        // ViewModel
        implementation(libs.androidx.lifecycle.viewmodel.ktx)
        // ViewModel utilities for Compose
        implementation(libs.androidx.lifecycle.viewmodel.compose)
        // LiveData
        implementation(libs.androidx.lifecycle.livedata.ktx)

    }
}