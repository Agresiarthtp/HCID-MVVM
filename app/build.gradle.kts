plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "28.0.3"
    dataBinding.isEnabled = true
    defaultConfig {
        applicationId = "com.kotlin.homecreditindonesia"
        minSdkVersion(16)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://private-a8e48-hcidtest.apiary-mock.com/\""
        )
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    androidExtensions {
        isExperimental = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.0.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.2.0")

    //network request
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation("com.google.code.gson:gson:2.8.5")

    //reactive
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")

    //MVVM
    implementation("android.arch.lifecycle:extensions:1.1.1")
    kapt("com.android.databinding:compiler:3.1.4")

    //GLIDE
    implementation("com.github.bumptech.glide:glide:4.9.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.9.0")

    // Anko Commons
    implementation("org.jetbrains.anko:anko-commons:0.10.5")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:2.2.2") {
        exclude("com.android.support', module: 'appcompat-v7")
        exclude("com.android.support', module: 'support-v4")
        exclude("com.android.support', module: 'design")
        exclude("com.android.support', module: 'recyclerview-v7")
    }
    androidTestImplementation("com.android.support.test:rules:1.0.2")

    //anko
    implementation("org.jetbrains.anko:anko:0.10.5")
    implementation("org.jetbrains.anko:anko-design:0.10.5")
    testImplementation("org.mockito:mockito-core:3.0.0")
    testImplementation("org.mockito:mockito-inline:3.0.0")
    implementation("com.squareup.picasso:picasso:2.71828")
}
