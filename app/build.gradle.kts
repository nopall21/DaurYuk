plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")}

android {
    namespace = "com.example.mycapstone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mycapstone"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField ("String", "API_KEY", "\"db874e166f4c473e9132d19a45135274\"")
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
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
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.paging:paging-runtime-ktx:3.1.1")
    implementation("androidx.room:room-common:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("com.github.bumptech.glide:glide:4.15.0")

    implementation("id.zelory:compressor:3.0.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")

    implementation("androidx.datastore:datastore-preferences:1.1.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.mockito:mockito-inline:3.12.4")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")
    testImplementation("io.strikt:strikt-core:0.31.0")

    androidTestImplementation("com.squareup.okhttp3:mockwebserver3:5.0.0-alpha.2")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    debugImplementation("androidx.fragment:fragment-testing:1.4.1")
    implementation("androidx.test.espresso:espresso-idling-resource:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.4.0")


    // Unit testing dependencies
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.9.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation ("androidx.paging:paging-common:3.1.0")

    // Coroutine dependencies for testing
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
}

dependencies {
    implementation("androidx.activity:activity:1.9.0")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("com.squareup.picasso:picasso:2.71828")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.paging:paging-runtime-ktx:3.1.1")
    implementation("com.github.bumptech.glide:glide:4.15.0")

    implementation("id.zelory:compressor:3.0.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")

    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.mockito:mockito-inline:3.12.4")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")
    testImplementation("io.strikt:strikt-core:0.31.0")

    androidTestImplementation("com.squareup.okhttp3:mockwebserver3:5.0.0-alpha.2")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    debugImplementation("androidx.fragment:fragment-testing:1.4.1")
    implementation("androidx.test.espresso:espresso-idling-resource:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.4.0")

    // Unit testing dependencies
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.9.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation ("androidx.paging:paging-common:3.1.0")

    // Coroutine dependencies for testing
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")

    // DataStore
    implementation("androidx.datastore:datastore-core-android:1.1.1")

    // ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.cardview:cardview:1.0.0")


    // Camera X
    val cameraxVersion = "1.3.0"
    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-view:$cameraxVersion")

    // Paging 3
    val pagingVersion = "3.0.0"
    implementation("androidx.paging:paging-runtime:$pagingVersion")

// Data Binding
//    implementation ("androidx.databinding:databinding-runtime:7.0.0")
//    kapt ("androidx.databinding:databinding-compiler:7.0.0")

    //FIREBASE
    implementation ("com.google.firebase:firebase-database:21.0.0")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation ("com.google.firebase:firebase-storage:21.0.0")
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore-ktx:24.0.1")

}