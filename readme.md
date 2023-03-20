# HW2 - 670HHHINGINFOR - Manuguerra Francesco 
## Esercizio in ambiente Android sul multitasking

Il progetto crea un'applicazione che esegue un'operazione di calcolo lunga su un thread separato per evitare di bloccare l'interfaccia utente.
Nella MainActivity, viene creato un oggetto CalculateTask che estende AsyncTask per eseguire un calcolo lungo su un thread separato. 
Quando l'utente preme il pulsante "Calcola", viene avviato il calcolo e viene mostrato un messaggio di attesa. 
Quando il calcolo è completato, viene aggiornato il risultato sul TextView.