package com.example.crystalball

enum class WaitingTime {
    PREDICTING_THE_FUTURE,
    GOING_TO_THE_GADALKA,
    ASKING_THE_SPIRITS,
    LISTENING_TO_THE_STARS,
    GET_AN_ANSWER;

    fun getProcess(): String {
        return when (this) {
            PREDICTING_THE_FUTURE -> "Predicting the future"
            GOING_TO_THE_GADALKA -> "Going to the gadalka"
            ASKING_THE_SPIRITS -> "Asking the spirits"
            LISTENING_TO_THE_STARS -> "Listening to the stars"
            GET_AN_ANSWER -> "Getting an answer"
        }
    }
}
