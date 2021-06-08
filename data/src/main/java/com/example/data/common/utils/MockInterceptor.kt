package com.example.data.common.utils

import com.example.data.BuildConfig
import okhttp3.*

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url().uri().toString()
            val responseString = when {
                uri.endsWith("response") -> getListOfReposBeingStarredJson
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                        responseString.toByteArray()
                    )
                )
                .addHeader("content-type", "application/json")
                .build()
        } else {
            //just to be on safe side.
            throw IllegalAccessError(
                "MockInterceptor is only meant for Testing Purposes and " +
                        "bound to be used only with DEBUG mode"
            )
        }
    }

}

const val getListOfReposBeingStarredJson = """
    {
    "fragrances":[
    {
    "fragranceName": "Versace Eros",
    "description": "Versace Eros is cologne with a great clean aroma scent that's not too intense, yet moderate scent that lasts all day.",
    "imageUrl": "https://www.pngkit.com/png/full/937-9375686_versace-eros-versace-blue-perfume.png",
    "price": 41.29,
    "userRating": 5
    },
    {
      "fragranceName": "Burberry",
      "description": "Smells wonderful. Not too strong and last longer",
      "imageUrl": "https://www.pngkit.com/png/full/381-3816595_burberry-touch-by-burberry.png",
      "price": 27.29,
      "userRating": 4
    },
    {
      "fragranceName": "Chrome",
      "description": "A flowers, citrus, maritime wonderful scent unique and one of the kind",
      "imageUrl": "https://www.pngkit.com/png/full/203-2031897_inspired-by-the-mediterranean-chrome-azzaro-perfume.png",
      "price": 25.89,
      "userRating": 4
    },
    {
      "fragranceName": "Mont Blanc Legend",
      "description": "MonteBlanc legend. It's definitely a scent anyone in your presence will remember.",
      "imageUrl": "https://e7.pngegg.com/pngimages/656/342/png-clipart-mont-blanc-legend-clean-first-blush-perfume-by-clean-2-14-oz-edt-spray-tester-for-women-eau-de-toilette-individuelle-perfume-by-mont-blanc-1-7-oz-edt-spay-for-women-perfume-miscellaneous-perfume-thumbnail.png",
      "price": 32.19,
      "userRating": 5
    },
    {
      "fragranceName": "Euphoria",
      "description": "Euphoria is a beautiful fragrance, for a romantic stay home dinner fragrance.",
      "imageUrl": "https://www.pngkit.com/png/full/417-4179451_calvin-klien-liquid-gold-euphoria-for-women-eau.png",
      "price": 34.99,
      "userRating": 5
    },
    {
      "fragranceName": "Sauvage",
      "description": "When you add Sauvage to your daily routine, you are choosing to surround yourself in a raw and fresh signature scent",
      "imageUrl": "https://www.pngkit.com/png/full/641-6416572_the-bottle-designed-by-pierre-camin-in-1966.png",
      "price": 108.49,
      "userRating": 4
    },
    {
      "fragranceName": "Cerruti 1881",
      "description": "A spicy blend of herbs, patchouli and fragran",
      "imageUrl": "https://brandslogos.com/wp-content/uploads/images/cerruti-1881-logo.png",
      "price": 18.19,
      "userRating": 4
    },
    {
      "fragranceName": "Pierre Cardin",
      "description": "Fresh and spicy, a scent that lingers, very ",
      "imageUrl": "https://www.sarantisgroup.com/media/v5pjfl2m/pierre-cardin-9.png",
      "price": 10.49,
      "userRating": 4
    },
    {
      "fragranceName": "Jimmy Choo",
      "description": "A daring fragrance with an addictive gourmand drydown",
      "imageUrl": "https://perfumegh.com/pub/media/catalog/product/cache/926507dc7f93631a094422215b778fe0/j/i/jimmy_choo_100ml_edp_fina_.png",
      "price": 41.99,
      "userRating": 4
    },
    {
      "fragranceName": "Polo Red",
      "description": "Embrace all things red with Polo Red from the fragrance design house of Ralph Lauren",
      "imageUrl": "https://www.pngkit.com/png/detail/126-1267818_ralph-lauren-polo-red-polo-red-ralph-lauren.png",
      "price": 55.29,
      "userRating": 5
    },
    {
      "fragranceName": "Vera Wang",
      "description": "A subtle blend of floral scents, Vera Wang for women is a versatile fragrance and a suitable accessory for both casual and formal wear",
      "imageUrl": "https://www.pngkit.com/png/full/780-7802117_krastase-chronologiste-gift-set-white-by-vera-wang.png",
      "price": 22.39,
      "userRating": 5
    },
    {
      "fragranceName": "Black Opium",
      "description": "Choose a scent that is luxurious and opulent when you spritz on Black Opium eau de parfum spray",
      "imageUrl": "https://c.perfumesclub.com/nw/black-opium/90-1.png",
      "price": 75.59,
      "userRating": 5
    },
    {
      "fragranceName": "Eternity Aqua",
      "description": "Men who want to wear a crisp blend of aquatic and woody scents choose Eternity Aqua eau de toilette by Calvin Klein.",
      "imageUrl": "https://www.pngkit.com/png/detail/449-4494029_calvin-klein-dive-into-freshness-calvin-klein-eternity.png",
      "price": 30.09,
      "userRating": 4
    },
    {
      "fragranceName": "Gucci Guilty",
      "description": "Explore and expand your boundaries with this Gucci Guilty eau de toilette spray, which was introduced in 2015 by Gucci",
      "imageUrl": "https://s.pngkit.com/png/small/623-6239920_gucci-guilty-absolute-eau-de-parfum-50-ml.png",
      "price": 46.69,
      "userRating": 5
    },
    {
      "fragranceName": "Dkny Be Delicious",
      "description": "Pay homage to your upbeat personality when you wear this Be Delicious eau de parfum spray for women from DKNY",
      "imageUrl": "https://www.pngkit.com/png/detail/510-5101648_dkny-be-delicious-shimmer-shine-e-dkny-be.png",
      "price": 30.79,
      "userRating": 5
    }
    ]
    }
"""