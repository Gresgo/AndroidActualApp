plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_CONFIG)
    kotlin(GradlePluginId.KAPT)
    id(GradlePluginId.HILT)
}

dependencies {
    implementation(project(":core:core"))

    kapt(Dependencies.ROOM_KAPT)

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    testImplementation(TestDependencies.JUNIT)
}