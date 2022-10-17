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












