
<h1 align="center">RAWG Games</h1>

<p align="center">  
This is the demo application based on modern Android development with Hilt, Coroutines, Flow, Jetpack (compose, navigation), and Material Design based on MVVM architecture.
</p></br>

## Screen Shot

</br>

| Main Screen | List Screen | Detail Screen |
| :---------------: | :---------------: | :---------------: |
|![](./preview/main.gif) |![](./preview/list.gif)  |![](./preview/detail.gif) |

</br>

## Tech stack & Open-source libraries

- Minimum SDK level 23
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- Jetpack
  - Compose - modern Android UI toolkit introduced by Google.
  - Lifecycle - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct the database using the abstract layer.(WIP)
- Architecture
  - Clean Architecture(multi module)
  - MVVM Architecture (View - ViewModel - Model)
  - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs.
- [coil](https://github.com/coil-kt/coil) - loading images.
- [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components for building ripple animation, and CardView.
</br>

## Open API
RAWG Games using the [RAWG API](https://rawg.io/apidocs) for constructing RESTful API.
RAWG API provides not only provides game information classified by genre and platform, but also provides plenty of game data including vendors and ratings.
</br>

## About the application
The original plan was to release an app that introduces game information and shares reviews based on jetpack compose. However, in my personal opinion, I felt it was still a bit early to apply compose to apps intended for official release rather than demo apps. I still have to use ExpreimentalApi, and I've realized that there were many cases where problems were solved with workarounds rather than best practices in terms of UI implementation. Threrfore, I've decided to implement whole features on the other project using existing XML way.
</br>

## Further development
- code optimization</br>
: need to take full advantage of reusability and State hoisting.

- backend</br>
: build backend using Firebase(caching data from RAWG api)to deal with req limiation issue and slow api response issue

- Features</br>
: Review, Favorite, Profile








