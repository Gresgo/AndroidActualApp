plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

gradlePlugin {
    plugins {
        register("android-config") {
            id = "android-config"
            implementationClass = "com.gresgo.aaa.plugin.AndroidConfigPlugin"
        }
    }
}