object AndroidConfig {
    const val APP_ID = "com.gresgo.aaa"
    const val COMPILE_SDK = 31
    const val MIN_SDK = 23
    const val TARGET_SDK = 31
    const val VERSION_CODE = 100000
    const val VERSION_NAME = "1.0"
}

interface BuildType {
    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }
}