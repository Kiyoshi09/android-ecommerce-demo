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
)