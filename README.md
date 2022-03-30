# SOS App

### Use Case
   You have decided that one of your contributions to the safety of
   individuals in the society is to build an SOS android app.
   This SOS app would help in contacting the police or family
   members, in a situation where you or someone is in distress and
   unable to make phone calls.
   
#### Features:
Here's what the app would do:
1. Take a picture of the scene, encode it to base64 string.
2. In real time, acquire the current location on the click of the capture image button
3. Send this information with preconfigured SOS numbers (i.e that of your family members or the police) via a REST endpoint.

#### Features:
- Jetpack Navigation.
- MVVM Architecture.
- Asynchronous API requests to server using Retrofit and Kotlin Coroutines.
- Used Hilt for dependency injection.
- Save contacts and retrieve from database using Room.
- LiveData and Kotlin Flow to monitor saved db values in real time.
