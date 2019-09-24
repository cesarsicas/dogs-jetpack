package com.cesarsicas.domain.breeds.interactors

import com.cesarsicas.domain.breeds.model.BreedDomain

class GetBreeds {

    fun execute(): List<BreedDomain> {
        return listOf(
            BreedDomain("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/hd1iiHXjK.jpg" ),
            BreedDomain("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/hd1iiHXjK.jpg" ),
            BreedDomain("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/rkiByec47_150x150.jpg" ),
            BreedDomain("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/rkiByec47_150x150.jpg" ),
            BreedDomain("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/GYC8Oeux6.jpg" ),
            BreedDomain("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/S1_8kx5Nm_150x150.jpg" )
        )
    }

}