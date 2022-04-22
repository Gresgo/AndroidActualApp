plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_CONFIG)
}

dependencies {
    api(Dependencies.KOTLIN)
    api(Dependencies.COROUTINES_CORE)
    api(Dependencies.COROUTINES_ANDROID)

    api(Dependencies.ROOM)
    api(Dependencies.ROOM_COROUTINES)

    api(project(":core:core-navigation"))
    api(project(":core:core-presentation"))
}