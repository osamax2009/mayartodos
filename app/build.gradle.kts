plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.scienceexperts.mayartodos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.scienceexperts.mayartodos"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    val compose_ui_version = "1.6.1"
    implementation ("androidx.compose.ui:ui:$compose_ui_version")
    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_ui_version")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$compose_ui_version")


    //room
    implementation("androidx.room:room-ktx:2.6.1")
    kapt( "androidx.room:room-common:2.6.1")
    kapt( "androidx.room:room-compiler:2.6.1")

    //
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-compiler:2.48")

}

kapt {
    correctErrorTypes = true
}