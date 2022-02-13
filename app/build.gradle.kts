plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        applicationId = Apps.appId
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
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
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/ASM")
    }
}

dependencies {

    implementation(project(":auth:impl"))
    implementation(project(":data:impl"))
    implementation(project(":common"))

    //implementation(project(Modules.core))
    implementation("androidx.core:core-ktx:1.7.0")

    //implementation(Compose.ui)
    implementation("androidx.compose.ui:ui:${Compose.composeVersion}")

    //implementation(Compose.material)
    implementation("androidx.compose.material:material:${Compose.composeVersion}")

    //implementation(Compose.ui)
    //implementation(Compose.uiToolingPreview)
    implementation("androidx.compose.ui:ui-tooling-preview:${Compose.composeVersion}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Compose.composeVersion}")

    implementation("androidx.compose.ui:ui:${Compose.composeVersion}")
    implementation("androidx.compose.material:material:${Compose.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Compose.composeVersion}")
    implementation("androidx.navigation:navigation-compose:${Compose.navigationComposeVersion}")

    implementation("com.google.dagger:dagger-android:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
}