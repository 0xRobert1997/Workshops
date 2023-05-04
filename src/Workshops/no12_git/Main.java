package Workshops.no12_git;

public class Main {

    public static void main(String[] args) {

        /*
        VCS - version control system
        SPOF - single point of failure
        DVCS - distributed version control system


        config git:
                 ustawiania dla:
        system - system operacyjny
        global - użytkownik
        local - repo

        git config --list
        git config --system --edit
        git config --global user.name "customName"

        ctrl + K -> skrót do commita w Intellij

        git add . -> kropka oznacza wszystkie pliki i katalogi w katalgu w którym teraz się znajdujemy

        git commit
        -a
        --all
            Tell the command to automatically stage files that have been modified and deleted,
            but new files you have not told git about are not affected

         git diff -> pokazuje zmiany w plikach
         git log -> pokazuje commity
         git log --pretty=oneline -> inaczej printuje commity

         git commit --amend -am "commit msg"
                jak dodamy commit ale chcemy go zmodyfikować (tylko jeśli nie został już wypchnięty)
                to dodajemy --amend żeby nadpisać poprzedni

          ctrl + k - skrót do commita

           git restore --staged .gitignore
                zdejmuje plik z stage

        // git revert
        // dodaje nowy commit kompensujący zmiany dodane w commicie revertującym

        --amend - do nadpisania poprzedniego commita

        git revert
        dodaje nowy commit kompensujący zmiany dodane w commicie revertującym


        git reset
        --soft       po prostu cofa commit
         git reset --soft <hash>  albo git reset HEAD~1
        --mixed -> zmiany po cofnięciu commita będą od-stagowane
        --hard -> oprócz cofnięcia commita usuwa też wszystkie zmiany które były wprowadzone w obrębie tego commita


        branch
        git branch - pokazuje branch na którym się znajdujemy oraz inne dostępne
        git branch -l "a*" -> pokazuje branche zaczynające się od litery a

        git branch nazwa-nowego-brancha - tworzy nowy branch
        git branch nowy-branch nazwa-nowego-brancha - tworzy nowy branch z innego
        git branch nowy-branch <hash commita> - tworzy nowy branch od danego commita

        git switch - robi to samo co checkout, tylko nazwa bardziej intuicyjna
        git checkout - przeniesienie się na dany branch
        git checkout nazwa-nowego-brancha
        git checkout main

        gdy przełączymy się na komkretny commit np.  git checkout <hash> to jesteśmy
        w stanie "detached HEAD" - czyli head nie wskazuje na branch tylko konkretny commit,
        żeby z tego wyjść trzeba użyć "git switch -"

        CRUD
        Create Read Update Delete

        git branch -m nowy-branch new-branch -> zmiana nazwy brancha przy podaniu starej i nowej nazwy
        git branch -m new-branch_name -> zmiana nazwy brancha na którym obecnie jesteśmy

        git branch -d <nazwa brancha> -> delete

        git reset --hard origin/main -> resetuje stan repo lokalnego do repo zdalnego na branchu main

        git merge <nazwa brancha>
        fast forward - gdy mergujemy branch z mainem ale na mainie nie ma żadnych nowych commitów (od momentu powstania brancha)
                        nie jest wtedy dodawany merge commit
                           git merge --no--ff -> spowoduje wymuszenie merge commita żeby było wraźnie widoczne kiedy został zrobiony merge

       Jak zrobimy merge to nie można go cofnąć, ale można wywołać git reset --soft HEAD~1 wtedy pozbędziemy się
       commita ale zmiany zostaną

        Rebase
        git rebase main
        git add Person.java
        git rebase --continue

        git stash - odkładanie zmian na półke
        git stash push  -> ctrl shift K
        git stash list
        git stash apply  -> zachowuje się jak stos, komenda przywraca najnowsze zestashowane zmiany
        git stash pop - zadziała jak złączenie git stash apply i jednoczesnego usunięcia wpisu ze stosu
        git stash drop - zrzuca stash z listy

        w Intellijeju w git->local changes jest opcja jest opcja Shelve Changes
            intellij nie używa w tym przypadku pod spodem gita


        git fetch
        git fetch origin

        git pull -> połączenie fetch i merge
        git pull --rebase

        git push --set-upstream origin new-feature    -> do wypchania brancha który jest tylko u nas lokalnie

        git tag
        git tag mytag1 482735e929fc9f7a0e413b6004d88a115d8548c7
                        jeśli nie podamy ID commita to otagujemy najnowszy commit
                        jeden commit może mieć kilka tagów
        git tag -f mytag1 9c41f6497770e47b4cd16c596164ab3f0849d29c
                         z flagą -f można przeisać tag do innego commita

        można się z checkout'ować na tag, wtedy checkoutujemy się tak na prawde na commit który jest tak otagowany

        git tag -a mytag2 -m "tag msg" 2102067b79cdd9ef9ca65fe628c4ccf5fb9d88ed

        git show mytag1
        git push origin mytag1
        git push --tags origin

        git tag -d mytag1  -> delete
        git push --delete origin mytag1


        Aliasy
        %h - skrócony commit hash
        %H - normalny commit hash
        %ad - data powstania commita
        %s - msg
        %d - branch lub tag
        %an - autor
        --date=short - tylko data
        %C(yellow) - kolor napisu
        %Creset - wracamy z kolorem do białego

        git config --global alias.nice-log "log --pretty=format:'%C(yellow)%h%Creset %ad | %Cgreen %s%Creset %Cred%d%Creset [%Cblue%an%Creset]' --date=short"
                                    ^ nazwa aliasa

        git blame Person.java
        w intellij alt + ~ 5


        cherry pick
        git cherry pick hash

        pull request PR || merge request MR
        feature-branch -> origin/feature-branch -> MR -> gradle build -> approve ->
        (origin/feature-branch => origin/master) -> git checkout master -> git pull



        */
    }
}

