// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id(GradlePluginId.ANDROID_APPLICATION) version GradlePluginVersion.ANDROID apply false
//    id(GradlePluginId.ANDROID_LIBRARY) version GradlePluginVersion.ANDROID apply false
//    id(GradlePluginId.ANDROID_KOTLIN) version GradlePluginVersion.KOTLIN apply false
//}
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePluginDependency.ANDROID_BUILD_TOOLS)
        classpath(GradlePluginDependency.KOTLIN_GRADLE_PLUGIN)
        classpath(GradlePluginDependency.HILT)
    }
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}