# Oppgave for Fremtind #
Av Anders Orset

## Beskrivelse ##
Integrasjonslag hvor man kan opprette avtale med parametrene navn, adresse og innhold og få  tilbake avtalestatus og avtalenr.

Integrasjonslaget sender kundeinformasjon (navn, adresse) videre til et fagsystem (en mock server) som returnerer samme info med et kundenummer.

Integrasjonslaget kaller så mockserveren på nytt med kundenummer, avtaleinnhold og en autogenerert avtalestatus "IKKE_SENDT" og får tilbake
samme informasjon med et avtalenummer.

Til slutt kaller integrasjonslaget mockserveren en siste gang for å simulere brevtjenesten. Her returneres
avtalen med avtalestatus endret til SENDT. 

## Hvordan kjøre ##

### Start node mock server (Fagsystem - Brevtjeneste) ###

cd mockServer
npm install
node mockServer.js &

### Start spring boot server med jersey (jax-rs) REST API ###
cd ..
gradle bootRun &

### Kjør integrasjonstester av "Opprett kunde" og "Opprett avtale" (forutsetter kjørende node server) mot mock server fra integrasjonslaget ###

gradle test

### Kjør ende-til-ende-test av "Opprett avtale" på integrasjonslag-controlleren ###

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
	"navn": "Test-navn",
	"adresse": "Test-adresse",
	"innhold": "Test-innhold"
}' \
  http://localhost:8080/forsikring/opprett

## Merknader til oppgaven ##

Gikk tom for strøm under mellomlanding i England hvor de har annen strøm, så fikk ikke tid til:
- Brevtjenesten i "Send avtale til kunde" returnerer alltid "SENDT" i denne implementasjonen. Oppgaveteksten kan tolkes dit at man også ønsker et case hvor den returnerer "IKKE_SENDT" og at avtalestatus skal endres i et nytt kall til fagsystemet
- Teste JAX-RS (Jersey)-kontrolleren med JUnit i stedet for manuelle CURL kall
- Validering av data som går via kontrolleren