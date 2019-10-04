package com.cesarsicas.domain.features.breeds.interactors

import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain

class GetBreeds {

    fun execute(repository: BreedsRepository): List<BreedDomain> {
        return repository.getBreeds()

//        return listOf(
//            BreedDomain("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/hd1iiHXjK.jpg" ),
//            BreedDomain("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/hd1iiHXjK.jpg" ),
//            BreedDomain("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/rkiByec47_150x150.jpg" ),
//            BreedDomain("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/rkiByec47_150x150.jpg" ),
//            BreedDomain("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/GYC8Oeux6.jpg" ),
//            BreedDomain("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/S1_8kx5Nm_150x150.jpg" )
//        )
    }

}