object GradlePluginVersion {
    const val ANDROID = "7.1.2"
    const val KOTLIN = "1.6.10"
    const val HILT = "2.40.1"
}

object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_KOTLIN = "org.jetbrains.kotlin.android"
    const val KOTLIN = "kotlin-android"
    const val KAPT = "kapt"
    const val HILT = "dagger.hilt.android.plugin"
    const val ANDROID_CONFIG = "android-config"
}

object GradlePluginDependency {
    const val ANDROID_BUILD_TOOLS = "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradlePluginVersion.KOTLIN}"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${GradlePluginVersion.HILT}"
}