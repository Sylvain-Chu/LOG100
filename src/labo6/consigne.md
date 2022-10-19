# Labo 6
***
## Table des matières
1. [Introduction](#intro)
2. [Spécifications](#specs)
3. [Implémentation](#imple)
4. [Validation](#val)
***
## Introduction 

   Bienvenue dans le cinquième laboratoire!

   Ce laboratoire est la première partie d’un projet de gestion d’écrans d’affichage dans un aéroport.

   Pour cette première partie, vous implémenterez, en utilisant le patron de conception Observateur (Observer design pattern), une **version simplifiée** de la fonctionnalité des écrans d’information qui sont communément présents dans les zones de départs des aéroports.
   
   Lisez attentivement les **spécifications** à la page suivante. La dernière page explique le **code fourni** ainsi que les tâches requises pour compléter l’implémentation du système.
***
### **Commentaires de documentation**

   Écrivez de la documentation Javadoc pour toutes les méthodes que vous rajouterez dans la classe ConsoleApp.


***
## Spécifications

### **Terminaux**
L’aéroport de notre exemple contient **trois terminaux**. Chaque terminal a un nombre différent de **portes d’embarquement**.

| Terminal | Nombre de portes |
|:--------:|:----------------:|
|    A     |        3         |
|    B     |        7         |
|    C     |        5         |

Les noms des portes d’embarquement sont la **concaténation** du nom du terminal et du numéro de la porte. Par exemple, C-3 correspond à la porte 3 du terminal C.
***
### **Écrans**

On considère trois types d’écran selon l’information qu’ils utilisent et leur place dans l’aéroport :

1. `AirportScreen` affiche l’état des vols de tous les terminaux
2. `TerminalScreen` affiche l’état des vols qui partent d’un terminal
3. `GateScreen` affiche l’état d’un vol qui part d’une porte d’embarquement


Il n’y a au plus qu’un vol par porte d’embarquement. Notez que, si à un certain moment, il n’y a aucun vol assigné pour une porte d’embarquement, dans un terminal ou dans tout l’aéroport, l’écran correspondant doit seulement montrer son nom.


Notre aéroport a deux écrans du type `AirportScreen`, trois écrans du type `TerminalScreen` pour chaque terminal et chaque porte d’embarquement a son propre écran du type `GateScreen`.

***
### **Vols**

Chaque vol est représenté par un objet de la classe `Flight` qui contient l’information suivante :

+ `company`, le nom abrégé de la compagnie aérienne (par exemple, “AC” pour Air Canada)
+ `flightNumber`, un nombre entier (int) qui représente le numéro du vol (par exemple, 168)
+ `destination`, le nom de la ville de destination (par exemple, “Amsterdam”)
+ `departureTime`, l’heure de départ du vol, représentée par un nombre du type int (par exemple, 15 h 28 correspond au nombre 1528)
+ `gate`, le nom de la porte d’embarquement du vol (par exemple, “C-2”)
+ `status`, l’état du vol, qui peut avoir les valeurs suivantes : “ON TIME”, “BOARDING”, “DELAYED”, ou “CANCELLED”

La compagnie et le numéro de vol constituent ensemble un identifiant unique pour le vol (par exemple, “AC168”). Notez que toutes les variables d’instance de la classe `Flight` sont privées. Définissez des accesseurs et mutateurs pour chacun d’eux.
Redéfinissez la méthode `toString` pour afficher l’information d’un vol dans l’ordre utilisé ci-dessus. Par exemple : “AC168 Amsterdam 1528 C-2 ON TIME”

***
### **Système**
Le système est représenté par la classe `ConsoleApp`. Tous les changements d’état et de porte d’embarquement sont faits par un système centralisé qui supporte les options suivantes :

1. `addFlight` crée un nouveau vol (objet de la classe Flight) et l’ajoute à l’information des vols.
2. `delayFlight` retarde un vol, i.e., change l’état du vol existant à “DELAYED”. Notez qu’aucun changement de l’heure du vol n’a lieu.
3. `changeGate` change la porte d’embarquement d’un vol existant. On peut changer le terminal et la porte. Si la nouvelle porte est occupée, on affiche le message “New gate X is not available”, où X est le nom de la nouvelle porte.
4. `cancelFlight` annule un vol, i.e., change l’état du vol existant à “CANCELLED”.
5. `notifyBoarding` notifie que l’embarquement pour un vol commence, i.e., change l’état du vol existant à “BOARDING”.
6. `removeFlight` enlève l’information d’un vol, lorsque celui-ci est parti par exemple. Notez que cette opération change l’information au niveau de l’aéroport, mais aussi du terminal et de la porte d’embarquement où le vol est assigné.

### Important

Il est essentiel que toute l’information soit affichée correctement sur tous les écrans le plus tôt possible après un changement. On ne doit créer aucun vol inutilement, c’est-à-dire en dehors de l’opération addFlight ; les autres opérations font des modifications sur des vols existants.




***
## Implémentation
   Vous devrez faire des adaptations et des généralisations aux exemples présentés pour le patron Observateur.

***
### **Gabarit**

Du code de base est fourni, avec les classes Observer, Subject, et ConsoleApp.

Chaque sous-classe de la classe Observer (AirportScreen, TerminalScreen, GateScreen) doit fournir sa propre implémentation de la méthode update. Cette méthode doit :
1. obtenir la liste des vols de l’objet du sous-type Subject que la classe observe (l’aéroport, un terminal ou une porte d’embarquement)
2. afficher le nom de l’écran (par exemple, "AIRPORT (1)" ou “GATE B-2”)
3. traverser la liste des vols pour afficher chaque vol, ligne par ligne et dans l’ordre dans lequel ils ont été ajoutés, avec des appels aux méthodes toString
   
Les sous-classes de la classe Subject (Airport, Terminal, Gate) possèdent chacune une liste de vols. Elles doivent implémenter les trois méthodes abstraites.

La méthode addFlight :

1. ajoute un vol à la fin de la liste des vols présente dans chaque sous-classe de Subject
2. notifie tous les objets observateurs d’un changement

La méthode removeFlight :

1. supprime le vol passé en paramètre de la liste des vols
2. notifie tous les objets observateurs d’un changement

La méthode getFlights retourne une référence vers la liste des vols.

***
### **Développement**
   
   
Complétez la classe ConsoleApp pour faire l’implémentation des six options de changement d’état. Implémentez chaque opération dans une méthode de la classe. Regardez la méthode addFlight pour un exemple de l’implémentation de la première opération. Utilisez la configuration de l’aéroport déjà implémentée dans ce fichier.
   
Après le choix de l’option, on demande à l’utilisateur d’entrer, dans l’ordre, le nom abrégé de la compagnie (par exemple, AC), puis le numéro de vol. Pour l’option Change Gate, on demandera aussi le nouveau terminal (A, B, ou C) et la nouvelle porte. Vous utiliserez les mêmes messages affichés dans la console pour demander l’information à l’utilisateur que dans l’exemple addFlight.
   
Comme dans addFlight, on fera les mises-à-jour dans l’ordre suivant : d’abord au niveau de l’aéroport, puis du terminal, et enfin de la porte d’embarquement. Si plusieurs terminaux / portes sont impliqués, on mettra d’abord à jour les sujets ayant perdu un vol, puis les autres.

   
Pour éviter d’avoir des méthodes trop longues, on va surcharger chaque méthode des opérations avec des paramètres représentant l’information autrement issue de la console. Par exemple, on crée la méthode surchargée addFlight(String company, int flightNumber, String destination, int departureTime, String terminal, int gateNumber, String status). Le reste de la fonctionnalité de chaque méthode est identique à la méthode sans paramètre. Lors de ce processus, on s’assurera d’éviter la répétition de code.
   
Ces surcharges vous permettront d’éviter d’avoir à entrer chaque fois l’information dans la console en définissant une séquence d’appels aux méthodes ci-dessus pour faire vos propres tests avec un scénario prédéfini, à l’aide du débogueur si nécessaire.

   
Pour simplifier votre implémentation, on a défini une classe pour le rôle d’observateur et une classe pour le rôle de sujet pour chaque type d’écran considéré dans ce projet.
   
Par exemple, les instances de votre classe TerminalScreen doivent observer les changements des vols d’un terminal (Terminal). Similairement, votre classe Airport doit contenir l’information de tous les vols, et tous ses changements doivent être observés directement par les écrans consacrés à l’information de l’aéroport.
   
Suivez les conventions montrées pour la définition des noms de vos classes et méthodes. Pour ce prototype, vous pouvez assumer que toutes les données sont correctes, c’est-à-dire qu’il n’est pas nécessaire de considérer la détection des erreurs ou la gestion d’exceptions.
   
Important

   Un objectif de ce projet est de minimiser les mises à jour des observateurs. Cela implique pour votre programme de notifier seulement les observateurs qui observent les sujets qui ont changés.
   



