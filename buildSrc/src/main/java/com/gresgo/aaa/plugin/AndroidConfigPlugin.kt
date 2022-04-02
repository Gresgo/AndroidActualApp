package com.gresgo.aaa.plugin

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidConfigPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyAndroidConfig()
            applyKotlinConfig()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply(GradlePluginId.KOTLIN)
        }
    }

    private fun Project.applyAndroidConfig() {
        android?.run {
            defaultConfig {
                minSdk = AndroidConfig.MIN_SDK
                targetSdk = AndroidConfig.TARGET_SDK
                compileSdkVersion(AndroidConfig.COMPILE_SDK)
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            composeOptions {
                kotlinCompilerExtensionVersion = Versions.COMPOSE
            }
        }
        app?.run {
            buildTypes {
                val proguardFiles = rootProject.fileTree("proguard").files +
                        getDefaultProguardFile("proguard-android-optimize.txt")

                getByName(BuildType.DEBUG) {

                }

                getByName(BuildType.RELEASE) {
                    isDebuggable = false
                    isMinifyEnabled = true
                    proguardFiles(*proguardFiles.toTypedArray())
                }
            }

            buildFeatures {
                compose = true
            }
        }
        library?.run {
            buildTypes {
                val proguardFiles = rootProject.fileTree("proguard").files +
                        getDefaultProguardFile("proguard-android-optimize.txt")

                getByName(BuildType.DEBUG) {
                }

                getByName(BuildType.RELEASE) {
                    isMinifyEnabled = true
                    proguardFiles(*proguardFiles.toTypedArray())
                }
            }

            buildFeatures {
                compose = true
            }
        }
    }

    private fun Project.applyKotlinConfig() {
        this.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }

}