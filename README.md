# Mathe 4 – Programmieraufgaben

Dieses Repository enthält die Lösungen zu den Programmieraufgaben des Moduls **Mathe 4**. Die Aufgaben umfassen numerische Verfahren sowie zahlentheoretische Algorithmen und werden als interaktive Konsolenanwendung bereitgestellt.

## Inhalt

| Übung | Thema | Klassen |
|-------|-------|---------|
| [Übung 7](#übung-7) | Newton-Verfahren & Numerische Integration | `NewtonVerfahren`, `TrapezRegel`, `SimpsonRegel` |
| [Übung 8](#übung-8) | Gradientenabstiegsverfahren | `GradientenAbstiegsVerfahren`, `Differenzenformel` |
| [Übung 9](#übung-9) | Numerische Lösung von DGLs | `EulerschesStreckenzugverfahren`, `RungeKuttaVerfahren` |
| [Übung 10](#übung-10) | Zahlenumrechnung | `ZahlenUmrechnung` |
| [Übung 11](#übung-11) | Zahlentheorie I | `GroessterGemeinsamerTeiler`, `Primfaktorzerlegung`, `DiophantischeGleichung` |
| [Übung 12](#übung-12) | Zahlentheorie II | `LineareGleichungen`, `ChinesischerRestsatz`, `EulerschePhiFunktion` |

---

## Übung 7

**Newton-Verfahren & Numerische Integration**

- **Aufgabe 1c)** – Newton-Verfahren zur Nullstellenberechnung einer Funktion f(x)
- **Aufgabe 2c)** – Numerische Integration einer Funktion mit der **Trapezregel** und der **Simpson-Regel**

## Übung 8

**Gradientenabstiegsverfahren**

- **Aufgabe 8.2** – Gradientenverfahren für eine eindimensionale Funktion f(x); Minimum oder Maximum wählbar
- **Aufgabe 8.3** – Gradientenverfahren für eine zweidimensionale Funktion f(x, y); Minimum oder Maximum wählbar

Die erste Ableitung wird numerisch über die zentrale **Differenzenformel** approximiert.

## Übung 9

**Numerische Lösung gewöhnlicher Differentialgleichungen**

- **Aufgabe a)** – **Eulersches Streckenzugverfahren** (explizites Euler-Verfahren)
- **Aufgabe b)** – **Runge-Kutta-Verfahren** (klassisches RK4-Verfahren)

Beide Verfahren lösen die DGL y' = y + e^x mit dem Anfangswert y(0) = 1 im Intervall [0, 0.2] mit Schrittweite h = 0.05.

## Übung 10

**Zahlenumrechnung zwischen verschiedenen Stellenwertsystemen**

- **Aufgabe a)** – Umrechnung einer Dezimalzahl in eine b-adische Zahl
- **Aufgabe b)** – Umrechnung einer b-adischen Zahl in eine Dezimalzahl
- **Aufgabe c)** – Umrechnung einer Zahl von Basis b1 in Basis b2

Unterstützte Basen: 2 bis 10.

## Übung 11

**Zahlentheorie I**

- **Aufgabe 1** – **Erweiterter euklidischer Algorithmus** (ggT und Bézout-Koeffizienten x, y)
- **Aufgabe 2** – **Primfaktorzerlegung** einer natürlichen Zahl
- **Aufgabe 3** – Lösung einer **diophantischen Gleichung** ax + by = c

## Übung 12

**Zahlentheorie II**

- **Aufgabe 1** – Lösung einer **linearen Kongruenz** ax ≡ b (mod n)
- **Aufgabe 2** – **Chinesischer Restsatz** für ein System von Kongruenzen
- **Aufgabe 3** – Berechnung der **Eulerschen φ-Funktion** φ(n)

---

## Voraussetzungen

- **Java 8** oder höher
- **Apache Maven** (zum Bauen des Projekts)

## Bauen

```bash
mvn compile
```

## Starten

```bash
mvn exec:java -Dexec.mainClass="me.moritzrohleder.Main"
```

Alternativ kann die Klasse `me.moritzrohleder.Main` direkt aus einer IDE (z. B. IntelliJ IDEA) gestartet werden.

## Bedienung

Nach dem Start erscheint ein interaktives Menü:

```
Willkommen zu den Programmier-Aufgaben des Moduls Mathe 4.
Bitte wählen Sie aus, ob Sie die Aufgabe 7, 8, 9, 10, 11 oder 12 sehen wollen.
```

Geben Sie die gewünschte Übungsnummer ein und folgen Sie den weiteren Anweisungen auf der Konsole.


## Projektstruktur

```
src/main/java/me/moritzrohleder/
├── Main.java                          # Einstiegspunkt & Hauptmenü
├── Uebung7/
│   ├── NewtonVerfahren.java
│   ├── NewtonMenu.java
│   ├── SimpsonRegel.java
│   ├── TrapezRegel.java
│   └── NumerischeIntegrationMenu.java
├── UebungAcht/
│   ├── GradientenAbstiegsVerfahren.java
│   └── Differenzenformel.java
├── UebungNeun/
│   ├── EulerschesStreckenzugverfahren.java
│   └── RungeKuttaVerfahren.java
├── UebungZehn/
│   └── ZahlenUmrechnung.java
├── uebungElf/
│   ├── GroessterGemeinsamerTeiler.java
│   ├── Primfaktorzerlegung.java
│   └── DiophantischeGleichung.java
└── UebungZwoelf/
    ├── LineareGleichungen.java
    ├── ChinesischerRestsatz.java
    └── EulerschePhiFunktion.java
```
