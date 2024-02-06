<p align="center">
  <img src="./app/src/main/res/mipmap-xhdpi/ic_launcher_foreground.webp" width="100" />
</p>
<p align="center">
    <h1 align="center">HOOPS INSIGHT<br/><br/>ANDROID CLIENT<br/>JETPACK COMPOSE</h1>
</p>
<p align="center">
    <em><code>► samet-byte/Android-JetpackCompose-HoopsInsight</code></em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/license-non_of_the_rights_reserved-orange" alt="license">
	<img src="https://img.shields.io/github/last-commit/samet-byte/Android-JetpackCompose-HoopsInsight?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/samet-byte/Android-JetpackCompose-HoopsInsight?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/samet-byte/Android-JetpackCompose-HoopsInsight?style=flat&color=0080ff" alt="repo-language-count">

<p>
<p align="center">
		<em>Developed with the software and tools below.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/Kotlin-7F52FF.svg?style=flat&logo=Kotlin&logoColor=white" alt="Kotlin">
	<img src="https://img.shields.io/badge/Org-77AA99.svg?style=flat&logo=Org&logoColor=white" alt="Org">
	<img src="https://img.shields.io/badge/Google-4285F4.svg?style=flat&logo=Google&logoColor=white" alt="Google">
	<img src="https://img.shields.io/badge/GitHub-181717.svg?style=flat&logo=GitHub&logoColor=white" alt="GitHub">
	<img src="https://img.shields.io/badge/JetBrains-000000.svg?style=flat&logo=JetBrains&logoColor=white" alt="JetBrains">
    <img src="https://img.shields.io/badge/AndroidStudio-000000.svg?style=flat&logo=AndroidStudio&logoColor=green" alt="Android Studio">
    <img src="https://img.shields.io/badge/Jetpack Compose-000000.svg?style=flat&logo=JetpackCompose&logoColor=blue" alt="Jetpack Compose">

</p>
<hr>

## Quick Links

> - [ Overview](#-overview)
> - [ Features](#-features)
> - [ Repository Structure](#-repository-structure)
> - [ Modules](#-modules)
> - [ Getting Started](#-getting-started)
    >
- [ Installation](#-installation)
>   - [ Running Android-JetpackCompose-HoopsInsight](#-running-Android-JetpackCompose-HoopsInsight)
>   - [ Tests](#-tests)
> - [ Project Roadmap](#-project-roadmap)
> - [ Contributing](#-contributing)
> - [ License](#-license)
> - [ Acknowledgments](#-acknowledgments)

---

## Overview

The NBA Data Viewer is an Android application built using Jetpack Compose, a modern UI toolkit for
building native UIs. The app leverages various libraries and technologies to provide a seamless and
engaging user experience.

---

## Screenshots

Samples from both dark and light themes are shown below:
<div style="text-align: center;">
<img  width="30%" height="auto" src="/screenshot/splash.png"/>
<img  width="30%" height="auto" src="/screenshot/welcome1.png"/>
<img  width="30%" height="auto" src="/screenshot/welcome2.png"/>
<img  width="30%" height="auto" src="/screenshot/welcome3.png"/>
<img  width="30%" height="auto" src="/screenshot/home_light.png"/>
<img  width="30%" height="auto" src="/screenshot/home.png"/>
<img  width="30%" height="auto" src="/screenshot/details_collapsed_mj.png">
<img  width="30%" height="auto" src="/screenshot/details_expanded_mj.png">
<img  width="30%" height="auto" src="/screenshot/search_initial.png">
<img  width="30%" height="auto" src="/screenshot/details_collapsed_larry.png">
<img  width="30%" height="auto" src="/screenshot/details_expanded_larry.png">
<img  width="30%" height="auto" src="/screenshot/search_complete.png">
<img  width="30%" height="auto" src="/screenshot/error_connection.png">
</div>
---

## Key Components

1. **Paging 3 Library:** Efficiently handles large data sets, enabling smooth pagination and
   efficient data loading from the REST API server.

2. **Ktor Framework:** The backend is powered by the Ktor framework, ensuring reliable communication
   between the Android app and the server.

3. **Coil:** Optimizes image loading and caching for a faster and more responsive user interface.

4. **Room Database (RoomDB):** Enables local data storage and retrieval, simplifying database
   operations.

5. **Hilt Dagger DI:** Manages dependency injection, facilitating a modular and maintainable
   codebase.

---

## Data Source

The app fetches data from a REST API server developed using the Ktor framework, which interacts with
the NBA.com API. Additionally, a Python script is used to automate data retrieval from the NBA.com
website.

---

## Key Features

- Seamless pagination and data loading using Paging 3.
- Efficient image loading and caching with Coil.
- Local data storage and retrieval through RoomDB.
- Modular and maintainable codebase with Hilt Dagger DI.
- Integration with a backend server developed with the Ktor framework.
- Automation of data retrieval from NBA.com using a Python script.

---

## Repository Structure

```sh
└── Android-JetpackCompose-HoopsInsight/
    ├── app
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── proguard-rules.pro
    │   └── src
    │       ├── androidTest
    │       │   └── java
    │       │       └── com
    │       ├── main
    │       │   ├── AndroidManifest.xml
    │       │   ├── java
    │       │   │   └── com
    │       │   └── res
    │       │       ├── drawable
    │       │       ├── mipmap-anydpi
    │       │       ├── mipmap-hdpi
    │       │       ├── mipmap-mdpi
    │       │       ├── mipmap-xhdpi
    │       │       ├── mipmap-xxhdpi
    │       │       ├── mipmap-xxxhdpi
    │       │       ├── values
    │       │       └── xml
    │       └── test
    │           └── java
    │               └── com
    ├── build.gradle.kts
    ├── gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle.kts
```

---

## Modules

<details closed><summary>.</summary>

| File                                                                                                                     | Summary |
|--------------------------------------------------------------------------------------------------------------------------|---------|
| [build.gradle.kts](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/build.gradle.kts)       |         |
| [settings.gradle.kts](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/settings.gradle.kts) |         |
| [gradlew.bat](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/gradlew.bat)                 |         |

</details>

<details closed><summary>app</summary>

| File                                                                                                                       | Summary |
|----------------------------------------------------------------------------------------------------------------------------|---------|
| [proguard-rules.pro](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/proguard-rules.pro) |         |
| [build.gradle.kts](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/build.gradle.kts)     |         |

</details>

<details closed><summary>app.src.androidTest.java.com.sametb.hoopsinsight</summary>

| File                                                                                                                                                                                    | Summary |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| [ExampleInstrumentedTest.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/androidTest/java/com/sametb/hoopsinsight/ExampleInstrumentedTest.kt) |         |

</details>

<details closed><summary>app.src.test.java.com.sametb.hoopsinsight</summary>

| File                                                                                                                                                             | Summary |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| [ExampleUnitTest.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/test/java/com/sametb/hoopsinsight/ExampleUnitTest.kt) |         |

</details>

<details closed><summary>app.src.main.java.com.sametb.hoopsinsight</summary>

| File                                                                                                                                                       | Summary |
|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| [MainActivity.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/MainActivity.kt) |         |

</details>

<details closed><summary>app.src.main.java.com.sametb.hoopsinsight.ui.theme</summary>

| File                                                                                                                                                  | Summary |
|-------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| [Color.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/ui/theme/Color.kt) |         |
| [Theme.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/ui/theme/Theme.kt) |         |
| [Type.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/ui/theme/Type.kt)   |         |

</details>

<details closed><summary>app.src.main.java.com.sametb.hoopsinsight.util.constants</summary>

| File                                                                                                                                                                      | Summary |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| [NavConstants.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/util/constants/NavConstants.kt) |         |

</details>

<details closed><summary>app.src.main.java.com.sametb.hoopsinsight.nav</summary>

| File                                                                                                                                                   | Summary |
|--------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| [NavGraph.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/nav/NavGraph.kt) |         |
| [Screen.kt](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/master/app/src/main/java/com/sametb/hoopsinsight/nav/Screen.kt)     |         |

</details>

---

## Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Kotlin**: `version 1.8.10`

### Installation

1. Clone the Android-JetpackCompose-HoopsInsight repository:

```sh
git clone https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight
```

2. Change to the project directory:

```sh
cd Android-JetpackCompose-HoopsInsight
```

3. Install the dependencies:

```sh
gradle build
```

### Running Android-JetpackCompose-HoopsInsight

Use the following command to run Android-JetpackCompose-HoopsInsight:

```sh
java -jar build/libs/myapp.jar
```

### Tests

To execute tests, run:

```sh
gradle test
```

---

## Contributing

Contributions are welcome! Here are several ways you can contribute:

- *
  *[Submit Pull Requests](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/blob/main/CONTRIBUTING.md)
  **: Review open PRs, and submit your own PRs.
- *
  *[Join the Discussions](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/discussions)
  **: Share your insights, provide feedback, or ask questions.
- **[Report Issues](https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight/issues)**:
  Submit bugs found or log feature requests for Android-jetpackcompose-hoopsinsight.

<details closed>
    <summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone https://github.com/samet-byte/Android-JetpackCompose-HoopsInsight
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe
   the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

## License

Non of the files in this repository are licensed. You are free to use, modify, and distribute the
code as you see fit.



---

## Acknowledgments

- @stevdza-san

---

[**Return**](#-quick-links)