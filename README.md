# Zotero Android

Zotero for Android - Your personal research assistant.

## Building the APK

This guide explains how to build the Zotero Android app from source.

### Prerequisites

1. **Java Development Kit (JDK) 17 or higher**
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use [OpenJDK](https://openjdk.org/)
   - Verify installation: `java -version`

2. **Android Studio** (recommended) or **Android SDK Command-line Tools**
   - Download from [Android Developers](https://developer.android.com/studio)
   - Make sure to install Android SDK 35 (or the version specified in `buildSrc/src/main/kotlin/BuildConfig.kt`)

3. **Git**
   - For cloning submodules

### Setup

1. **Clone the repository with submodules:**
   ```bash
   git clone --recursive https://github.com/zotero/zotero-android.git
   cd zotero-android
   ```

   If you already cloned without `--recursive`, initialize submodules with:
   ```bash
   git submodule update --init --recursive
   ```

2. **Set up environment variables** (if not using Android Studio):
   ```bash
   export ANDROID_HOME=/path/to/your/android/sdk
   export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools
   ```

### Building

#### Using Android Studio

1. Open Android Studio
2. Select **File > Open** and choose the `zotero-android` directory
3. Wait for Gradle sync to complete
4. Select **Build > Build Bundle(s) / APK(s) > Build APK(s)**
5. The APK will be located in `app/build/outputs/apk/`

#### Using Command Line

1. **Build debug APK:**
   ```bash
   ./gradlew assembleDevDebug
   ```
   Output: `app/build/outputs/apk/dev/debug/app-dev-debug.apk`

2. **Build release APK (requires signing configuration):**
   ```bash
   ./gradlew assembleInternalRelease
   ```
   Output: `app/build/outputs/apk/internal/release/app-internal-release.apk`

### Build Variants

The app has several build variants:

| Flavor   | Build Type | Description                    |
|----------|------------|--------------------------------|
| dev      | debug      | Development build with debug tools |
| dev      | release    | Development build, release config |
| internal | debug      | Internal testing build |
| internal | release    | Production release build |

### Common Build Commands

```bash
# Clean build
./gradlew clean

# Build all variants
./gradlew assemble

# Run unit tests
./gradlew test

# Install debug APK directly to connected device
./gradlew installDevDebug
```

### Troubleshooting

1. **Gradle sync fails:**
   - Ensure you have the correct JDK version
   - Check your internet connection for dependency downloads
   - Try `./gradlew --refresh-dependencies`

2. **SDK not found:**
   - Create a `local.properties` file in the project root with:
     ```
     sdk.dir=/path/to/your/android/sdk
     ```

3. **Submodule issues:**
   - Run `git submodule update --init --recursive` to ensure all submodules are properly initialized

### E-Ink Mode

This version includes an E-Ink mode optimized for low-resolution non-touchscreen E-Ink devices:

- High contrast colors (pure black and white)
- Reduced animations to minimize screen refreshing
- Better readability on E-Ink displays

To enable E-Ink mode:
1. Open the app
2. Go to **Settings**
3. Toggle **E-Ink Mode**
4. Restart the app for changes to take effect

## License

This project is licensed under the AGPL-3.0 License - see the [COPYING](COPYING) file for details.
