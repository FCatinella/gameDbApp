plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("commonBuildConfig"){
            id = "it.fabiocati.thegamedb.build_logic.commonConfig"
            implementationClass = "it.fabiocati.thegamedb.build_logic.CommonBuildConfig"
            version = 1
        }
    }
}

dependencies {
    compileOnly(libs.android.tools.build)
}