const bodyParser = require('body-parser');
const express = require('express');

const app = express();
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.post('/opprettKunde', (req, res) => {

    let navn = req.body.navn;
    let adresse = req.body.adresse;

    res.json({
        kundeNr: Math.floor(Math.random() * 100 + 1),
        navn: navn,
        adresse: adresse
    });
});

app.post('/opprettAvtale', (req, res) => {
    let innhold = req.body.innhold;
    let avtaleStatus = req.body.avtaleStatus;
    res.json({
        kundeNr: req.body.kundeNr,
        avtaleNr: Math.floor(Math.random() * 100 + 1),
        innhold: innhold,
        avtaleStatus: avtaleStatus
    });
});

app.post('/sendAvtaleTilKunde', (req, res) => {
    let innhold = req.body.innhold;
    res.json({
        kundeNr: req.body.kundeNr,
        avtaleNr: req.body.avtaleNr,
        innhold: req.body.innhold,
        avtaleStatus: "SENDT"
    });
});

app.listen(3000);