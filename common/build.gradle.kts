plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
        kotlinCompilerVersion = Compose.composeCompilerVersion
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(Libs.androidxCore)
    implementation(Libs.appcompat)
    implementation(Libs.androidMaterial)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation("com.google.dagger:dagger-android:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")

    implementation("androidx.compose.ui:ui:${Compose.composeVersion}")
    implementation("androidx.compose.material:material:${Compose.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Compose.composeVersion}")
    implementation("androidx.navigation:navigation-compose:${Compose.navigationComposeVersion}")

    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
}