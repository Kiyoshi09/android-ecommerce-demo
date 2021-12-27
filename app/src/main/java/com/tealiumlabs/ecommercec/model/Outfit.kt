package com.tealiumlabs.ecommercec.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Outfit(
    val id: Long,
    val category: OutfitCategory,
    val name: String,
    val price: Double,
    val imageUrl_s: String,
    val imageUrl_l: String,
    val description: String
)

val outfitList = listOf<Outfit>(
   Outfit(
       id = 1001,
       category = OutfitCategory.Women,
       name = "TORI TANK",
       price = 60.00,
       imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk003t.jpg",
       imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk003t.jpg",
       description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
   ),

    Outfit(
        id = 1003,
        category = OutfitCategory.Women,
        name = "ELIZABETH KNIT TOP",
        price = 210.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk012t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk012t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1004,
        category = OutfitCategory.Women,
        name = "LAFAYETTE CONVERTIBLE DRESS",
        price = 340.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd013t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd013t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1005,
        category = OutfitCategory.Women,
        name = "NOLITA CAMI",
        price = 150.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk000t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk000t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1006,
        category = OutfitCategory.Women,
        name = "LUDLOW OXFORD TOP",
        price = 185.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk009t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk009t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1007,
        category = OutfitCategory.Women,
        name = "DELANCY CARDIGAN SWEATER",
        price = 275.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk006t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/b/wbk006t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1008,
        category = OutfitCategory.Women,
        name = "TRIBECA SKINNY JEAN",
        price = 185.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/p/wpd000t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/p/wpd000t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1009,
        category = OutfitCategory.Women,
        name = "DUMBO BOYFRIEND JEAN",
        price = 210.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/p/wpd005t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/p/wpd005t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1010,
        category = OutfitCategory.Women,
        name = "ESSEX PENCIL SKIRT",
        price = 185.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd000t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd000t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1011,
        category = OutfitCategory.Women,
        name = "RACER BACK MAXI DRESS",
        price = 224.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd005t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd005t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1012,
        category = OutfitCategory.Women,
        name = "LUDLOW SHEATH DRESS",
        price = 305.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd008t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd008t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 1002,
        category = OutfitCategory.Women,
        name = "PARK AVENUE PLEAT FRONT TROUSERS",
        price = 245.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/p/wpd010t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/p/wpd010t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2001,
        category = OutfitCategory.Men,
        name = "LINEN BLAZER",
        price = 455.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj012t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj012t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2002,
        category = OutfitCategory.Men,
        name = "BOWERY CHINO PANTS",
        price = 140.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd003t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd003t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2003,
        category = OutfitCategory.Men,
        name = "KHAKI BOWERY CHINO PANTS",
        price = 140.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd000t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd000t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2004,
        category = OutfitCategory.Men,
        name = "CHELSEA TEE",
        price = 75.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk004t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk004t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2005,
        category = OutfitCategory.Men,
        name = "PLAID COTTON SHIRT",
        price = 160.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj006t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj006t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2006,
        category = OutfitCategory.Men,
        name = "SLIM FIT DOBBY OXFORD SHIRT",
        price = 140.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj003t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj003t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2007,
        category = OutfitCategory.Men,
        name = "FRENCH CUFF COTTON TWILL OXFORD",
        price = 190.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj000t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj000t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2008,
        category = OutfitCategory.Men,
        name = "CHELSEA TEE",
        price = 75.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk000t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk000t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2009,
        category = OutfitCategory.Men,
        name = "CHELSEA TEE",
        price = 75.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk002t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk002t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2010,
        category = OutfitCategory.Men,
        name = "MERINO V-NECK PULLOVER SWEATER",
        price = 210.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk006t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk006t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2011,
        category = OutfitCategory.Men,
        name = "LEXINGTON CARDIGAN SWEATER",
        price = 240.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk009t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk009t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2012,
        category = OutfitCategory.Men,
        name = "CORE STRIPED SPORT SHIRT",
        price = 125.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk012t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk012t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2013,
        category = OutfitCategory.Men,
        name = "THE ESSENTIAL BOOT CUT JEAN",
        price = 140.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd006t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd006t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2014,
        category = OutfitCategory.Men,
        name = "FLAT FRONT TROUSER",
        price = 195.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd012t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/p/mpd012t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2015,
        category = OutfitCategory.Men,
        name = "SULLIVAN SPORT COAT",
        price = 510.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj009t.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj009t.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 2016,
        category = OutfitCategory.Men,
        name = "STRETCH COTTON BLAZER",
        price = 490.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj015t_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj015t_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3001,
        category = OutfitCategory.Accessories,
        name = "JACKIE O ROUND SUNGLASSES",
        price = 225.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/ace001_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/ace001_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3002,
        category = OutfitCategory.Accessories,
        name = "RETRO CHIC EYEGLASSES",
        price = 295.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/ace002a_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/ace002a_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3003,
        category = OutfitCategory.Accessories,
        name = "AVIATOR SUNGLASSES",
        price = 295.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/ace000a_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/ace000a_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3004,
        category = OutfitCategory.Accessories,
        name = "BLUE HORIZONS BRACELETS",
        price = 55.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/acj006_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/acj006_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3005,
        category = OutfitCategory.Accessories,
        name = "PEARL STUD EARRINGS",
        price = 110.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/acj003_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/acj003_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3006,
        category = OutfitCategory.Accessories,
        name = "SWING TIME EARRINGS",
        price = 75.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/acj004_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/acj004_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3007,
        category = OutfitCategory.Accessories,
        name = "SILVER DESERT NECKLACE",
        price = 210.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/acj000_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/acj000_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3008,
        category = OutfitCategory.Accessories,
        name = "SWISS MOVEMENT SPORTS WATCH",
        price = 500.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/acj005_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/acj005_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3009,
        category = OutfitCategory.Accessories,
        name = "PEARL NECKLACE SET",
        price = 110.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/acj007_1_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/acj007_1_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3010,
        category = OutfitCategory.Accessories,
        name = "DORIAN PERFORATED OXFORD",
        price = 410.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/m/ams000a_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/m/ams000a_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3011,
        category = OutfitCategory.Accessories,
        name = "SUEDE LOAFER, NAVY",
        price = 310.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/m/ams010a_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/m/ams010a_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3012,
        category = OutfitCategory.Accessories,
        name = "WINGTIP COGNAC OXFORD",
        price = 375.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/m/ams005a_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/m/ams005a_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3013,
        category = OutfitCategory.Accessories,
        name = "HANA FLAT, CHARCOAL",
        price = 210.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/w/aws010.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/w/aws010.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3014,
        category = OutfitCategory.Accessories,
        name = "ANN ANKLE BOOT",
        price = 470.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/w/aws005a_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/w/aws005a_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 3015,
        category = OutfitCategory.Accessories,
        name = "BARCLAY D'ORSAY PUMP, NUDE",
        price = 390.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/w/aws000a_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/w/aws000a_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4001,
        category = OutfitCategory.HomeDecor,
        name = "PILLOW AND THROW SET",
        price = 485.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb010.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb010.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4002,
        category = OutfitCategory.HomeDecor,
        name = "ALICE IN WONDERLAND",
        price = 5.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/l/alice_wonderland_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/l/alice_wonderland.jpeg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4003,
        category = OutfitCategory.HomeDecor,
        name = "FIRE [KALIMA REMIX] BY UNANNOUNCED GUEST",
        price = 2.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/u/n/unannouncedguest_.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/u/n/unannouncedguest.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4004,
        category = OutfitCategory.HomeDecor,
        name = "LOVE IS AN ETERNAL LIE BY THE SLEEPING TREE",
        price = 2.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/s/l/sleepingtree_.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/l/sleepingtree_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4005,
        category = OutfitCategory.HomeDecor,
        name = "CAN'T STOP IT BY SHEARER",
        price = 2.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/s/h/shearer__2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/h/shearer_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4006,
        category = OutfitCategory.HomeDecor,
        name = "FALLING BY I AM NOT LEFTHANDED",
        price = 2.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/l/e/lefthanded_.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/l/e/lefthanded.png",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4007,
        category = OutfitCategory.HomeDecor,
        name = "A TALE OF TWO CITIES",
        price = 10.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/t/a/tale_two_cities_.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/t/a/tale_two_cities_1_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4008,
        category = OutfitCategory.HomeDecor,
        name = "AROUND THE WORLD IN 80 DAYS",
        price = 5.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/8/0/80_days_.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/8/0/80_days.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4009,
        category = OutfitCategory.HomeDecor,
        name = "IF YOU WERE BY KESHCO",
        price = 2.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/k/e/keshco_.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/k/e/keshco.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4010,
        category = OutfitCategory.HomeDecor,
        name = "BODY WASH WITH LEMON FLOWER EXTRACT AND ALOE VERA",
        price = 28.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb000_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb000_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4011,
        category = OutfitCategory.HomeDecor,
        name = "GRAMERCY THROW",
        price = 275.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb009_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb009_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4012,
        category = OutfitCategory.HomeDecor,
        name = "PARK ROW THROW",
        price = 120.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb008_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb008_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4013,
        category = OutfitCategory.HomeDecor,
        name = "CARNEGIE ALPACA THROW",
        price = 275.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb007_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb007_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4014,
        category = OutfitCategory.HomeDecor,
        name = "TITIAN RAW SILK PILLOW",
        price = 100.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb005_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb005_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4015,
        category = OutfitCategory.HomeDecor,
        name = "BATH MINERALS AND SALT",
        price = 25.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb001_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb001_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4016,
        category = OutfitCategory.HomeDecor,
        name = "MADISON LX2200",
        price = 425.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hde001t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hde001t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4017,
        category = OutfitCategory.HomeDecor,
        name = "MP3 PLAYER WITH AUDIO",
        price = 275.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hde012_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hde012_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4018,
        category = OutfitCategory.HomeDecor,
        name = "MADISON RX3400",
        price = 815.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hde003a_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hde003a_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 4019,
        category = OutfitCategory.HomeDecor,
        name = "COMPACT MP3 PLAYER",
        price = 815.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hde013__1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hde013__1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 5001,
        category = OutfitCategory.Sale,
        name = "RACER BACK MAXI DRESS",
        price = 224.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd005t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/s/wsd005t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 5002,
        category = OutfitCategory.Sale,
        name = "SLIM FIT DOBBY OXFORD SHIRT",
        price = 140.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/m/s/msj003t_2.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/s/msj003t_2.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 5003,
        category = OutfitCategory.Sale,
        name = "JACKIE O ROUND SUNGLASSES",
        price = 225.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/a/c/ace001_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/c/ace001_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

    Outfit(
        id = 5004,
        category = OutfitCategory.Sale,
        name = "PARK ROW THROW",
        price = 120.00,
        imageUrl_s = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/small_image/210x/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb008_1.jpg",
        imageUrl_l = "https://ecommerce.tealiumdemo.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/d/hdb008_1.jpg",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    ),

)