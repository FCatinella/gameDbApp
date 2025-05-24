plugins {
    kotlin("plugin.serialization") version libs.versions.kotlin
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.gradle.secrets)
    alias(libs.plugins.ksp)
    alias(libs.plugins.common.config)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "it.fabiocati.thegamedb"

    defaultConfig {
        applicationId = "it.fabiocati.thegamedb"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = false
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.material3.windowSizeClass)

    implementation(libs.kotlinx.serialization.json)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation (libs.androidx.material.icons.extended)

    implementation(libs.ktor.client)
    implementation(libs.ktor.auth)
    implementation(libs.ktor.contentNegotiation)
    implementation(libs.ktor.serialization.json)

    implementation(libs.compose.destinations.core)
    ksp(libs.compose.destinations.ksp)

    implementation(libs.coil)
    implementation(libs.coil.compose)

    implementation(libs.kotlinx.datetime)

    implementation(libs.bundles.androidx.glance.app.widget)
    implementation(libs.androidx.glance.appwidget.preview)
    implementation(libs.androidx.glance.glance.preview)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}