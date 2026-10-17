# Lemonade

Exercice du chapitre 7 (Développement d'applications mobiles) : associer un comportement à un clic.

Petite appli Android en Jetpack Compose qui fait préparer une citronnade en appuyant sur l'image.

## Fonctionnement

1. On voit un citronnier. On appuie dessus pour prendre un citron.
2. On appuie plusieurs fois sur le citron pour le presser. Le nombre de pressions est tiré au hasard entre 2 et 4 à chaque fois.
3. Le verre de citronnade s'affiche, on appuie pour le boire.
4. Le verre est vide, on appuie pour recommencer depuis le citronnier.

## Infos du projet

- Nom : Lemonade
- Package : `com.example.lemonade`
- SDK minimum : 24
- Modèle de départ : Empty Activity (Compose)

## Fichiers modifiés

- `app/src/main/java/com/example/lemonade/MainActivity.kt` : l'écran et la logique des étapes
- `app/src/main/res/values/strings.xml` : les textes et descriptions des images
- `app/src/main/res/drawable/` : les 4 images de l'exercice (`lemon_tree`, `lemon_squeeze`, `lemon_drink`, `lemon_restart`)

## Lancer le projet

1. Cloner le dépôt et l'ouvrir dans Android Studio.
2. Attendre la synchronisation Gradle.
3. Lancer sur un émulateur ou un téléphone (Run ▶).

## Auteur

Newton