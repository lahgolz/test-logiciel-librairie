# Bibliothèque - Projet de Test Logiciel

[![Build & Test](https://github.com/lahgolz/test-logiciel-librairie/actions/workflows/maven.yml/badge.svg)](https://github.com/lahgolz/test-logiciel-librairie/actions/workflows/maven.yml)

Ce projet implémente un système de gestion de bibliothèque en Java avec des tests unitaires.

## Prérequis

- Java 21
- Maven

## Structure du Projet

Le projet est organisé comme suit:
- `src/main/java/com/library/` : Code source principal
  - `Book.java` : Classe représentant un livre
  - `Library.java` : Classe gérant la collection de livres
- `src/test/java/com/library/` : Tests
  - `LibraryTest.java` : Tests unitaires
  - `LibraryFunctionalTest.java` : Tests fonctionnels

## Compilation

Pour compiler le projet, exécutez:

```bash
mvn compile
```

## Exécution des Tests

Pour exécuter les tests unitaires:

```bash
mvn test
```

## Exécution du Test Fonctionnel

Pour exécuter le test fonctionnel:

```bash
java -cp target/classes:target/test-classes com.library.LibraryFunctionalTest
```
