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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
        kotlinCompilerVersion = Compose.composeCompilerVersion
    }
}

dependencies {

    implementation(project(":common"))
    api(project(":auth:api"))
    api(project(":data:api"))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation("androidx.compose.ui:ui:${Compose.composeVersion}")
    implementation("androidx.compose.material:material:${Compose.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Compose.composeVersion}")
    implementation("androidx.navigation:navigation-compose:${Compose.navigationComposeVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Compose.composeVersion}")
    implementation("androidx.compose.material:material-icons-extended:${Compose.composeVersion}")

    implementation("com.google.dagger:dagger-android:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
}