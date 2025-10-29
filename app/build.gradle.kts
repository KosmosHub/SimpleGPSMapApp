plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.gpsmapapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.gpsmapapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // ------------------------------
        // 👇 ADICIÓN: exponer MAPS_KEY a BuildConfig
        // Lee la propiedad MAPS_KEY desde local.properties (si existe),
        // si no existe se deja cadena vacía.
        val mapsKey: String = (project.findProperty("MAPS_KEY") as? String) ?: ""
        buildConfigField("String", "MAPS_KEY", "\"$mapsKey\"")
        // ------------------------------
    }

    buildTypes {
        release {
            // ------------------------------
            // 👇 AJUSTES DE SEGURIDAD PARA RELEASE
            // Activar minify (R8) para ofuscar código en release.
            // Asegurarse que debuggable esté en false.
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Garantizar que release no sea debuggable
            isDebuggable = false
            // ------------------------------
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // ✅ Google Maps y ubicación
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation(libs.play.services.location)

    // ------------------------------
    // 👇 ADICIÓN: EncryptedSharedPreferences (AndroidX Security)
    implementation("androidx.security:security-crypto:1.1.0")
    // ------------------------------

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
