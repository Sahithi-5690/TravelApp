

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.androidproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidproject"
        minSdk = 24
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
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.ui.test.android)
    implementation(libs.litert.support.api)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
//    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation ("com.github.bumptech.glide:glide:4.14.2")  // Latest stable version
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")  // For annotation processing
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.27")
    implementation ("com.google.android.material:material:1.8.0 ")



}