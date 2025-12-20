# Some important knowledge
Criando um lib aar, subindo em um naven local e utilizando no projeto: https://github.com/cstevanato/ViewModelExtends

## Como publicar no Maven Local
1. Publicar no Maven Local
```bash
./gradlew :mathlib:publishToMavenLocal
```

2. Gerar AAR sem publicar
```bash
./gradlew :mathlib:assembleRelease
```

3. Limpar, reconstruir e publicar
```bash
./gradlew clean
./gradlew :mathlib:assembleRelease
./gradlew :mathlib:publishToMavenLocal
```

## Usar a Biblioteca em Outro Projeto

1. settings.gradle.kts (do projeto que vai usar)
```bash
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()  // Adicionar esta linha
    }
}
```

2. build.gradle.kts (Module: app)
```bash
dependencies {
    implementation("com.example:mathlib:1.0.0")
    
    // outras dependências...
}
```

# Reference projects
https://github.com/android/nowinandroid/tree/main/build-logic
