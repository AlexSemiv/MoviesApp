object Apps {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val appId = "com.example.moviesapp"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "7.1.1"
    const val kotlin = "1.6.10"
    const val appcompat = "1.4.1"

    /* test */
    const val junit = "4.12"

    /* libs */
    const val androidxVersion = "1.7.0"
    const val androidMaterialVersion = "1.5.0"

    const val daggerVersion = "2.40.5"
    const val retrofitVersion = "2.9.0"
    const val okhttpInterceptorVersion = "5.0.0-alpha.2"
}

object Build {
    const val androidBuildTools = "com.android.tools.build:gradle:${Versions.gradle}"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Compose {

    const val navigationComposeVersion = "2.4.1"
    const val composeVersion = "1.1.0"
    const val composeCompilerVersion = "1.5.21"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxVersion}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterialVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}