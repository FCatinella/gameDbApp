package it.fabiocati.thegamedb.build_logic

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.ProductFlavor
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

private typealias CommonExtensionType = CommonExtension<
        BuildFeatures,
        BuildType,
        DefaultConfig,
        ProductFlavor,
        AndroidResources,
        Installation
        >

class CommonBuildConfig : Plugin<Project> {
    override fun apply(target: Project) {
        target.android.apply {
            compileSdk = 35
            defaultConfig {
                minSdk = 31
            }
            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            buildFeatures {
                compose = true
                buildConfig = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.8"
            }
            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

        }
    }
}

@Suppress("UNCHECKED_CAST")
private val Project.android: CommonExtensionType
    get() {
        return try {
            this.extensions.getByType(ApplicationExtension::class.java) as CommonExtensionType
        } catch (_: Exception) {
            this.extensions.getByType(LibraryExtension::class.java) as CommonExtensionType
        }
    }