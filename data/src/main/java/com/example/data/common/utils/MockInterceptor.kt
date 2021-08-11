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
    "productId": 1,
    "productName": "Versace Eros",
    "productDescription": "Versace Eros is cologne with a great clean aroma scent that's not too intense, yet moderate scent that lasts all day.",
    "productImageUrl": "https://www.pngkit.com/png/full/937-9375686_versace-eros-versace-blue-perfume.png",
    "productPrice": 41.29,
    "userRating": 5,
    "addedToCart": true,
    "addedToWishList": false
    },
    {
      "productId": 2,
      "productName": "Burberry",
      "productDescription": "Smells wonderful. Not too strong and last longer",
      "productImageUrl": "https://www.pngkit.com/png/full/381-3816595_burberry-touch-by-burberry.png",
      "productPrice": 27.29,
      "userRating": 4,
      "addedToCart": true,
      "addedToWishList": true
    },
    {
      "productId": 3,
      "productName": "Chrome",
      "productDescription": "A flowers, citrus, maritime wonderful scent unique and one of the kind",
      "productImageUrl": "https://www.pngkit.com/png/full/203-2031897_inspired-by-the-mediterranean-chrome-azzaro-perfume.png",
      "productPrice": 25.89,
      "userRating": 4,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 4,
      "productName": "Mont Blanc Legend",
      "productDescription": "MonteBlanc legend. It's definitely a scent anyone in your presence will remember.",
      "productImageUrl": "https://e7.pngegg.com/pngimages/656/342/png-clipart-mont-blanc-legend-clean-first-blush-perfume-by-clean-2-14-oz-edt-spray-tester-for-women-eau-de-toilette-individuelle-perfume-by-mont-blanc-1-7-oz-edt-spay-for-women-perfume-miscellaneous-perfume-thumbnail.png",
      "productPrice": 32.19,
      "userRating": 5,
      "addedToCart": false,
      "addedToWishList": true
    },
    {
      "productId": 5,
      "productName": "Euphoria",
      "productDescription": "Euphoria is a beautiful fragrance, for a romantic stay home dinner fragrance.",
      "productImageUrl": "https://www.pngkit.com/png/full/417-4179451_calvin-klien-liquid-gold-euphoria-for-women-eau.png",
      "productPrice": 34.99,
      "userRating": 5,
      "addedToCart": true,
      "addedToWishList": true
    },
    {
      "productId": 6,
      "productName": "Sauvage",
      "productDescription": "When you add Sauvage to your daily routine, you are choosing to surround yourself in a raw and fresh signature scent",
      "productImageUrl": "https://www.pngkit.com/png/full/641-6416572_the-bottle-designed-by-pierre-camin-in-1966.png",
      "productPrice": 108.49,
      "userRating": 4,
      "addedToCart": true,
      "addedToWishList": false
    },
    {
      "productId": 7,
      "productName": "Cerruti 1881",
      "productDescription": "A spicy blend of herbs, patchouli and fragran",
      "productImageUrl": "https://brandslogos.com/wp-content/uploads/images/cerruti-1881-logo.png",
      "productPrice": 18.19,
      "userRating": 4,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 8,
      "productName": "Pierre Cardin",
      "productDescription": "Fresh and spicy, a scent that lingers, very ",
      "productImageUrl": "https://www.sarantisgroup.com/media/v5pjfl2m/pierre-cardin-9.png",
      "productPrice": 10.49,
      "userRating": 4,
      "addedToCart": false,
      "addedToWishList": true
    },
    {
      "productId": 9,
      "productName": "Jimmy Choo",
      "productDescription": "A daring fragrance with an addictive gourmand drydown",
      "productImageUrl": "https://perfumegh.com/pub/media/catalog/product/cache/926507dc7f93631a094422215b778fe0/j/i/jimmy_choo_100ml_edp_fina_.png",
      "productPrice": 41.99,
      "userRating": 4,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 10,
      "productName": "Polo Red",
      "productDescription": "Embrace all things red with Polo Red from the fragrance design house of Ralph Lauren",
      "productImageUrl": "https://www.pngkit.com/png/detail/126-1267818_ralph-lauren-polo-red-polo-red-ralph-lauren.png",
      "productPrice": 55.29,
      "userRating": 5,
      "addedToCart": false,
      "addedToWishList": true
    },
    {
      "productId": 11,
      "productName": "Vera Wang",
      "productDescription": "A subtle blend of floral scents, Vera Wang for women is a versatile fragrance and a suitable accessory for both casual and formal wear",
      "productImageUrl": "https://www.pngkit.com/png/full/780-7802117_krastase-chronologiste-gift-set-white-by-vera-wang.png",
      "productPrice": 22.39,
      "userRating": 5,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 12,
      "productName": "Black Opium",
      "productDescription": "Choose a scent that is luxurious and opulent when you spritz on Black Opium eau de parfum spray",
      "productImageUrl": "https://c.perfumesclub.com/nw/black-opium/90-1.png",
      "productPrice": 75.59,
      "userRating": 5,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 13,
      "productName": "Eternity Aqua",
      "productDescription": "Men who want to wear a crisp blend of aquatic and woody scents choose Eternity Aqua eau de toilette by Calvin Klein.",
      "productImageUrl": "https://www.pngkit.com/png/detail/449-4494029_calvin-klein-dive-into-freshness-calvin-klein-eternity.png",
      "productPrice": 30.09,
      "userRating": 4,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 14,
      "productName": "Gucci Guilty",
      "productDescription": "Explore and expand your boundaries with this Gucci Guilty eau de toilette spray, which was introduced in 2015 by Gucci",
      "productImageUrl": "https://s.pngkit.com/png/small/623-6239920_gucci-guilty-absolute-eau-de-parfum-50-ml.png",
      "productPrice": 46.69,
      "userRating": 5,
      "addedToCart": false,
      "addedToWishList": false
    },
    {
      "productId": 15,
      "productName": "Dkny Be Delicious",
      "productDescription": "Pay homage to your upbeat personality when you wear this Be Delicious eau de parfum spray for women from DKNY",
      "productImageUrl": "https://www.pngkit.com/png/detail/510-5101648_dkny-be-delicious-shimmer-shine-e-dkny-be.png",
      "productPrice": 30.79,
      "userRating": 5,
      "addedToCart": false,
      "addedToWishList": true
    }
    ]
    }
"""