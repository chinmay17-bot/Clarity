# 📒 Clarity - Note-Taking App (Kotlin Multiplatform)

A modern **note-taking application** built with **Kotlin Multiplatform (KMP)**, using **Jetpack Compose (Material 3)** for Android and **SwiftUI / Compose for iOS** for iOS.  
The app shares common business logic in **Kotlin** and connects to a **Spring Boot** backend with full **authentication (login/register)** functionality.

---

## 🛠 Tech Stack

| Layer | Technology |
|-------|-----------|
| Shared Code | Kotlin Multiplatform (KMP) |
| Android Frontend | Kotlin, Jetpack Compose, Material 3 |
| iOS Frontend | SwiftUI / Compose for iOS (KMP integration) |
| Backend | Spring Boot, Kotlin, Spring Security, MongoDB |
| Database | MongoDB |
| Tools | IntelliJ IDEA, Android Studio, Xcode, Gradle, Postman |

---

## 🚀 Features

- User **Registration** and **Login** with secure password hashing
- **CRUD Notes** functionality: create, read, update, delete
- Shared **business logic** across Android and iOS using KMP
- Modern **Material 3 UI** on Android
- Responsive and native UI on iOS
- **Persistent storage** using MongoDB
- Structured project separation:
  - `shared/` → KMP shared code (logic, models, API calls)
  - `android-app/` → Android frontend
  - `ios-app/` → iOS frontend
  - `backend-api/` → Spring Boot backend

---
