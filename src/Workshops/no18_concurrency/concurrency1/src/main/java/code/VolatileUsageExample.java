package code;

public class VolatileUsageExample {

    public volatile boolean someVariableUpdatedByManyThreads = true;

    public void executeExample(){
        while(someVariableUpdatedByManyThreads) {
            System.out.println("Nadal ustawione na true");
        }
        System.out.println("Inny wątek zmienił na false");
    }

/*    Poprzez oznaczenie someVariableUpdatedByManyThreads słowem kluczowym volatile, gwarantujemy, że
    wartość zmiennej zostanie każdorazowo (przy każdej iteracji pętli while) pobrana z RAMu i w momencie
    aktualizacji jej wartości przez inny wątek - pętla zostanie przerwana już w pierwszej iteracji po zmianie.*/

    /*
    HAPPENS BEFORE
    zmiana kolejności wykonywania linijek kodu ze względu na optymalizację

    firstVariable = 2;
    secondVariable = 5;
    firstVariable = firstVariable++;

    firstVariable jest trzymane w cache’u i wszystkie wymagane przez
        program operacje są na nim wykonywane od razu
    Zapis do zmiennej, który w kodzie znajduje się przed zapisem do zmiennej volatile, zawsze wydarzy się
        wcześniej (happens before!), przed zapisem do tej zmiennej volatile
     */
}
