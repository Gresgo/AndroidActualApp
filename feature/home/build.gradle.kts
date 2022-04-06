plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_CONFIG)
    kotlin(GradlePluginId.KAPT)
    id(GradlePluginId.HILT)
}

dependencies {
    implementation(project(":core:core"))

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)
}