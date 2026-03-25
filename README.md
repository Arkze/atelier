# 🐱 CatMash API - Backend (Spring Boot)

## 📖 Description

CatMash API est une application backend développée avec **Spring Boot** suivant une **architecture hexagonale (Ports & Adapters)**.

Elle permet de :
- 👍 Liker des chats
- ⭐ Super liker des chats
- 🏆 Consulter un leaderboard
- 🎲 Récupérer des chats aléatoires pour voter (2 par 2 - like ou super like)

## 🏗️ Architecture

Le projet suit une **architecture hexagonale** :

### 🔹 Détails

- **Domain**
  - `Cat`, `LikeType`
  - Interfaces pour use case métier : `GetCatLeaderboardUseCase`, `GetCatScoreUseCase`,`GetRandomCatUseCase`, `LikeCatUseCase`
  - Exceptions métier (`CatNotFoundException`)

- **Application**
  - Implementation Use cases (`CatLikeScoreService`, `GetCatLeaderboardService`, `GetCatScoreService`, `GetRandomCatService`)

- **Infrastructure**
  - REST Controller (`CatController`)
  - JPA (`CatEntity`, `CatJpaRepository`)
  - Adapter (`CatRepositoryAdapter`)
  - Exception handler (`GlobalExceptionHandler`)


## 🚀 Lancement de l'application

### ✅ Prérequis

- Docker Compose

### ▶️ Lancer l'application

```bash
docker-compose up
```
