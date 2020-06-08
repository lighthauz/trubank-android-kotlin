![Github Actions](https://github.com/lighthauz/trubank-android-kotlin/workflows/Trubank%20CI/badge.svg)
[![Codecov](https://codecov.io/gh/lighthauz/trubank-android-kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/lighthauz/trubank-android-kotlin)


This project is a new version of the existing Trubank android app, in this case, this project was born with the intention of exploring some of the features and frameworks that we are not able to implement in the Trusona app and sdk right now with the idea of using most of the topics mentioned here in a near future. 

This project attempts to:

1. Explain how Trusona android mobile sdk can be implemented from an Android app written in Kotlin and discover what limitations could be faced.
2. Explore the new Architecture components of the new Android Architecture created by Google as the new way to develop android apps and discover if there is any conflict or unexpected behavior by still doing the old way in the Android SDK.
3. Use MVVM instead of MVP as an architectural pattern based on topic #2 and figure out what pros and cons we can face.
4. Use clean architecture and reveal how the Trusona SDK calls can fit in that, so this project can be used as a reference for future customers.
5. Explore some of the differences between the most popular frameworks used in Kotlin and Java such as Koin vs Dagger for dependency injection, Coroutines vs RXJava for async calls, Moshi vs GSON for JSON parsing, and others. And discover If there is any conflict since the SDK is already using some of them. 

This document is still in progress...