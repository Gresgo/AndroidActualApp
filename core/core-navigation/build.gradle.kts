plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_CONFIG)
}

dependencies {
    api(Dependencies.COMPOSE_NAVIGATION)
    api(Dependencies.HILT_COMPOSE_NAVIGATION)
}