object Versions {
    const val COMPOSE = "1.1.1"
}

object Dependencies {
    // core
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${GradlePluginVersion.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:1.7.0"

    // appcompat
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.4.1"
    const val MATERIAL = "com.google.android.material:material:1.5.0"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"

    // compose
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${Versions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:1.4.0"
}

object TestDependencies {
    const val JUNIT = "junit:junit:4.13.2"
    const val JUNIT_EXT = "androidx.test.ext:junit:1.1.3"
    const val JUNIT_COMPOSE = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.4.0"
}