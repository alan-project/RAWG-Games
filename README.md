### Alan's ongoing personal project #3 ~~(WIP)~~<br>
### ~~- Target date (release)~~
~~Feb 19, 2022~~
</br>
<div align="center">

The original plan to build this application was to release an app that introduces game information and shares reviews based on jetpack compose. However, in my personal opinion, I felt it was still a bit early to apply compose to apps intended for official release rather than demo apps. I still have to use ExpreimentalApi, and I've realized that there were many cases where problems were solved with workarounds rather than best practices in terms of UI implementation. Threrfore, I'm going to discontinue this project and goint to implement this game app again with the existing XML way.
</div>
</br>
</br>
</br>

| Main Screen | List Screen | Detail Screen |
| :---------------: | :---------------: | :---------------: |
|![](./preview/main.gif) |![](./preview/list.gif)  |![](./preview/detail.gif) |

</pr>
</br>

### - Teck stack
- Clean architecture(multi module) with MVVM pattern</br>
- Kotlin</br>
- Coroutines</br>
- Jetpack Compose</br>
- Hilt</br>
- retrofit, room </br>
- Coil, Timber,  </br></br>

### - Issues to be fixed
- API</br>
: too slow api response</br>
: limitaion of req based on free account</br>
: unstable server

### - Further development
- code optimization</br>
: need to take full advantage of reusability and State hoisting.

- backend</br>
: build backend using Firebase(caching data from RAWG api)to deal with req limiation issue and slow api response issue

- Features</br>
: Review, Favorite








