plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_CONFIG)
    kotlin(GradlePluginId.KAPT)
    id(GradlePluginId.HILT)
}

android {
    defaultConfig {
        applicationId = AndroidConfig.APP_ID
    }
}

dependencies {
    implementation(project(":core:core"))
    implementation(project(":core:core-navigation"))
    implementation(project(":core:core-presentation"))

    implementation(project(":feature:home"))

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.JUNIT_EXT)
    androidTestImplementation(TestDependencies.ESPRESSO)
}