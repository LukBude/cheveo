# Unicorn Frontend

## Probeaufgabe Fullstack Entwickler

### Aufgabenbeschreibung

**Angular als Frontend**
<br/>
**Beliebiges Backend**

#### Kundenwunsch:

Der Kunde wünscht sich eine Mitarbeiterverwaltung. In dieser Verwaltung soll es möglich sein Mitarbeiter anzulegen, zu editieren und zu löschen. Die Verwaltung soll in einer Liste dargestellt werden. Von dieser Liste aus kann man nun per Klick die Detailansicht eines Mitarbeiters öffnen.

Im Backend kann eine feste Liste von Mitarbeitern angelegt werden, welche im Arbeitsspeicher gehalten wird (Es sei denn du bevorzugst Dynamik). Die Daten sollen über eine REST-Schnittstelle zur Verfügung gestellt werden. Es ist nicht nötig für diesen Test eine Datenbank anzulegen (es sei denn du möchtest es gerne dynamisch machen).

Das Design überlassen wir deiner Kreativität.

Im Folgenden haben wir dir ein Datenmodell bereitgestellt, sodass du eine Orientierung für einen Mitarbeiter hast.

Datenmodell (Beispiel als Json)

```
{
	id: 1,
	firstname: „Max“,
	lastname: „Mustermann“,
	birthdate: „24.02.1992”,
	address: {
		city: „Bonn“,
		zip: „53225“,
		street: „Musterstrasse“,
		number: “1 A”
	}
	phone: „01234 473923“
}
```

## Durchführung (Frontend & Backend)

Nachfolgendes gilt für das Frontend und Backen gleichermaßen.

Bitte checke einen feature branch aus und arbeite auf diesem. Nachdem du gepusht hast, eröffne bitte einen Pull Request.

Damit wir sehen können wann du beginnst, möchten wir gerne, dass du einen initial commit erstellst mit dem Text: <br/>
`git commit -m "feat(client): starting developing"`

Wenn du die Aufgabe abgeschlossen hast: <br/>
`git commit -m "feat(client): done developing"`

Für das Backend bitte folgendes Repo verwenden: <br/>
[Backend Repository](https://github.com/Cheveo/UnicornBackend)

**Happy Coding & Viel Erfolg!**


