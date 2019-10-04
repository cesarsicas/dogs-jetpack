package com.cesarsicas.domain.features.breeds.model

data class BreedDomain(   val id:Int,
                          val name:String,
                          val temperament:String,
                          val height:String,
                          val weight:String,
                          val originCountry:String,
                          val thumb:String)