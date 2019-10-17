package com.cesarsicas.dogsjetpack.features.breeds.model

import com.cesarsicas.domain.features.breeds.model.BreedDomain

internal data class Breed(val id:Int,
                          val name:String,
                          val temperament:String,
                          val height:String,
                          val weight:String,
                          val originCountry:String,
                          val thumb:String){


        companion object {
            fun fromDomainObject(domainObject: BreedDomain): Breed {
                return Breed(
                    domainObject.id,
                    domainObject.name,
                    domainObject.temperament,
                    domainObject.height,
                    domainObject.weight,
                    domainObject.originCountry,
                    domainObject.thumb)
            }
        }

}

