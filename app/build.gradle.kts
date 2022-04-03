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
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.COMPOSE_COMPILER)
    implementation(Dependencies.COMPOSE_FOUNDATION)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_UI_TOOLING)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_ANIMATIONS)
    implementation(Dependencies.COMPOSE_ACTIVITY)

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.JUNIT_EXT)
    androidTestImplementation(TestDependencies.ESPRESSO)
}