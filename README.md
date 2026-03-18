Mini-projekt programistyczny – kNN

· Zaimplementować od zera klasyfikator kNN, pracujący w dwóch trybach:

    o Klasyfikuje podany przez użytkownika wektor testowy, lub zawierający je własny plik tekstowy, na bazie całego pliku iris.txt

    o Dzieli dane na dwa zbiory – treningowy i testowy – i zwraca celność (% poprawnie zaklasyfikowanych rekordów) klasyfikacji zbioru testowego na bazie zbioru treningowego. Proporcje według własnych preferencji, ale powinny znajdować się w przedziale między 3:2 a 4:1 (trening:test)

· Program ma wczytać dane Iris z pliku tekstowego. Należy wykorzystać cały plik i samodzielnie podzielić dane na testowe i treningowe wewnątrz programu, a NIE tworzyć dwóch nowych plików.

· Algorytm liczy odległość euklidesową klasyfikowanego wektora od wszystkich wektorów treningowych i klasyfikuje go jako modę z klas k najbliższych wektorów.

· Program ma wypisywać celność modelu, czyli % poprawnie zaklasyfikowanych wektorów testowych.

· Wymagany interfejs do ręcznego wpisywania wektorów testowych (na wyjściu: klasyfikacja) i interfejs plikowy (program wczytuje podany plik i zwraca poprawnie zaklasyfikowany odsetek wektorów)


· Nie można używać zewnętrznych bibliotek.

· Podejście obiektowe NIE jest wymagane

· Program powinien zostać napisany w języku java, python lub c++

· Wymagana jest dokładna znajomość działania kodu.

· Projekt będzie sprawdzany przeze mnie na zajęciach.


· Propozycja dodatkowej funkcjonalności dla chętnych:

o moduł wyrysowujący wykres zależności między celnością, a k.
