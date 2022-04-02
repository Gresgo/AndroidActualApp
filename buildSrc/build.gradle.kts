plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

gradlePlugin {
    plugins {
        register("android-config") {
            id = "android-config"
            implementationClass = "com.gresgo.aaa.plugin.AndroidConfigPlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation("com.android.tools.build:gradle-api:7.1.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.6.10")
}