# Mini-projekt programistyczny – kNN

## Wymagania

### Główna funkcjonalność

- Zaimplementować od zera klasyfikator kNN, pracujący w dwóch trybach:
  - **Tryb 1**: Klasyfikuje podany przez użytkownika wektor testowy lub zawarte w pliku tekstowym wektory na bazie całego pliku iris.txt
  - **Tryb 2**: Dzieli dane na zbiory treningowy i testowy, zwraca celność (% poprawnie zaklasyfikowanych rekordów) klasyfikacji zbioru testowego na bazie zbioru treningowego. Proporcje według własnych preferencji w przedziale 3:2 a 4:1 (trening:test)

### Implementacja

- Program ma wczytać dane Iris z pliku tekstowego
- Wykorzystać cały plik i samodzielnie podzielić dane na testowe i treningowe wewnątrz programu (NIE tworzyć nowych plików)
- Algorytm liczy odległość euklidesową klasyfikowanego wektora od wszystkich wektorów treningowych
- Klasyfikuje wektor jako modę z klas k najbliższych wektorów
- Program wypisuje celność modelu (% poprawnie zaklasyfikowanych wektorów testowych)

### Interfejsy

- Interfejs do ręcznego wpisywania wektorów testowych (wyjście: klasyfikacja)
- Interfejs plikowy (program wczytuje plik i zwraca % poprawnie zaklasyfikowanych wektorów)

### Ograniczenia

- ❌ Nie można używać zewnętrznych bibliotek
- ❌ Podejście obiektowe NIE jest wymagane
- ✅ Program w języku: Java, Python lub C++
- ✅ Wymagana dokładna znajomość działania kodu
- ✅ Projekt będzie sprawdzany na zajęciach

## Dodatkowe funkcjonalności (opcjonalnie)

- Moduł wyrysowujący wykres zależności między celnością a parametrem k
