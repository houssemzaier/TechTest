package fr.radiofrance.android.test.domain.models

data class Station(
    val id: String,
    val title: String,
    val baseline: String,
    val description: String,
)

data class Show(
    val id: String,
    val title: String,
    val standFirst: String,
)
