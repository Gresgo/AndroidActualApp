plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_CONFIG)
}

dependencies {
    api(Dependencies.KOTLIN)
    api(Dependencies.COROUTINES_CORE)
    api(Dependencies.COROUTINES_ANDROID)

    api(project(":core:core-navigation"))
}