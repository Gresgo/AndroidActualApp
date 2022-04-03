plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_CONFIG)
}

dependencies {
    api(Dependencies.COMPOSE_COMPILER)
    api(Dependencies.COMPOSE_FOUNDATION)
    api(Dependencies.COMPOSE_UI)
    api(Dependencies.COMPOSE_UI_TOOLING)
    api(Dependencies.COMPOSE_MATERIAL)
    api(Dependencies.COMPOSE_ANIMATIONS)
    api(Dependencies.COMPOSE_ACTIVITY)
}