package com.example.myapplication.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

fun convertStringToLocalDate(brazilDate: String) : LocalDate{

    val dateFormatterFromBrazil = DateTimeFormatter
        .ofPattern("dd/MM/yyyy")

    val localDateFormat =  LocalDate
        .parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat


}
fun calcularIdade(dataNascimento: String) : Int{

    val hoje = LocalDate.now()

    val nascimentoArray = dataNascimento.split("-").toTypedArray()

    val nascimento = LocalDate.of(
            nascimentoArray[0].toInt(),
            nascimentoArray[1].toInt(),
            nascimentoArray[2].toInt()
    )

    val idade = Period.between(nascimento, hoje).years
    return  idade
}