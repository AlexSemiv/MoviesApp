pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MoviesApp"
include(":app")
include(":common")
include(":data")
include(":data:api")
include(":data:impl")
include(":auth")
include(":auth:api")
include(":auth:impl")
