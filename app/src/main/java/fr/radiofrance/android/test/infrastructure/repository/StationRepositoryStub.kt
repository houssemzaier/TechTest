package fr.radiofrance.android.test.infrastructure.repository

import fr.radiofrance.android.test.domain.models.Show
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.android.test.domain.repository.StationRepository

class StationRepositoryStub : StationRepository {
    override suspend fun getAllStationList(): List<Station> {
        return listOf(
            Station(
                id = "FRANCEINTER",
                title = "France Inter",
                baseline = "Le direct de France Inter",
                description = "Joyeuse, savante et populaire, France Inter est la radio généraliste de service public",
            ),
            Station(
                id = "FRANCEINFO",
                title = "franceinfo",
                baseline = "Et tout est plus clair",
                description = "L'actualité en direct et en continu avec le média global du service public",
            ),
            Station(
                id = "FRANCEMUSIQUE",
                title = "France Musique",
                baseline = "Ce monde a besoin de musique",
                description = "Classique mais pas que… Chaque jour, la musique se vit intensément sur France Musique.",
            ),
            Station(
                id = "FRANCECULTURE",
                title = "France Culture",
                baseline = "France Culture, l'esprit d'ouverture",
                description = "",
            ),
            Station(
                id = "MOUV",
                title = "Mouv'",
                baseline = "Mouv’, ta radio Hip Hop",
                description = "La radio jeune et connectée de Radio France : musique, lien social et cultures urbaines.",
            ),
            Station(
                id = "FIP",
                title = "FIP",
                baseline = "La radio la plus éclectique du monde",
                description = "La radio musicale la plus éclectique.",
            ),
            Station(
                id = "FRANCEBLEU",
                title = "France Bleu",
                baseline = "",
                description = "",
            ),
        )
    }

    override suspend fun getShowListByStation(station: Station): List<Show> {
        return listOf(
            Show(
                "00754de4-4aef-11e5-add9-005056a87fa3_56",
                "Je suis d'où je viens - rediffusion",
                "Une personnalité se confie à Faustine Bollaert.",
            ),
            Show(
                "00fc1c1c-f5eb-4e5e-b2a9-cec76a7a66b9_56",
                "Plantez-vous !",
                "Que vous viviez en ville ou à la campagne, que vous ayez un balcon, un jardin ou juste un appui de fenêtre, Ophélie Damblé, agricultrice urbaine, vous invite, comme elle, à vous « planter » pour y arriver, et à réveiller le jardinier qui sommeille en vous.",
            ),
            Show(
                "01287fbf-f5d5-4801-8ae0-d7ace680214d_56",
                "Willy Rovelli met les points sur les i",
                "Tout ce que Willy Rovelli a retenu de l'actualité, avec ironie, humour et bonne humeur.",
            ),
            Show(
                "01688218-5e1a-433f-9890-02f04cfc37a8_56",
                "La story du jour",
                "La story du jour c’est une petite encyclopédie étonnante ! le principe est d’apprendre des choses que, peut-être, vous ne trouveriez pas ailleurs.",
            ),
            Show(
                "0203b1ea-e3e4-4ec8-95bc-f84871eb90e0_56",
                "Les escales de l'Happy Hour",
                "On se change les idées et on prend la vie du bon côté.",
            ),
            Show(
                "029e9345-153e-4c00-99c3-ea5806c7880f_13",
                "Le 1/4 d'Heure Sport",
                "",
            ),
            Show(
                "03bcd98f-6957-4cc7-b011-e3e68cb3cc30_56",
                "C’est ma chanson",
                "",
            ),
            Show(
                "057df929-de81-4372-b518-2073adcdd4be_56",
                "Les conseils sorties de France Bleu",
                "3 minutes chaque samedi et chaque dimanche pour trouver de quoi sortir ce weekend !",
            ),
            Show(
                "0874e197-2885-46e4-8b3a-b64540ec1994_56",
                "C'est arrivé par hasard",
                "La chance, la bonne étoile, le destin, les circonstances sont à l’origine de bien des découvertes, inventions ou autres événements.",
            ),
        )
    }
}
