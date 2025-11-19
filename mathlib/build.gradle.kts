plugins {
    id("com.example.convention.android-library")
    id("maven-publish")
}

android {
    namespace = "com.example.mathlib"
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.example"
                artifactId = "mathlib"
                version = "1.0.0"
            }
        }

        repositories {
            mavenLocal()
        }
    }
}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}