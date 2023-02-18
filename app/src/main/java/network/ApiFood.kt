package network

import com.squareup.moshi.Json

data class ApiFood(
    @Json(name = "count") var count: Double?,
    @Json(name = "from") var from: Double?,
    @Json(name = "hits") var hits: List<Hit>?,
    @Json(name = "more") var more: Boolean?,
    @Json(name = "q") var q: String?,
    @Json(name = "to") var to: Double?
)

data class Hit(
    @Json(name = "recipe") var recipe: Recipe?
)

data class Recipe(
    @Json(name = "calories") var calories: Double?,
    @Json(name = "cautions") var cautions: List<String>?,
    @Json(name = "cuisineType") var cuisineType: List<String>?,
    @Json(name = "dietLabels") var dietLabels: List<String>?,
    @Json(name = "digest") var digest: List<Digest>?,
    @Json(name = "dishType") var dishType: List<String>?,
    @Json(name = "healthLabels") var healthLabels: List<String>?,
    @Json(name = "image") var image: String?,
    @Json(name = "ingredientLines") var ingredientLines: List<String>?,
    @Json(name = "ingredients") var ingredients: List<Ingredient>?,
    @Json(name = "label") var label: String?,
    @Json(name = "mealType") var mealType: List<String>?,
    @Json(name = "shareAs") var shareAs: String?,
    @Json(name = "source") var source: String?,
    @Json(name = "totalDaily") var totalDaily: TotalDaily?,
    @Json(name = "totalNutrients") var totalNutrients: TotalNutrients?,
    @Json(name = "totalTime") var totalTime: Double?,
    @Json(name = "totalWeight") var totalWeight: Double?,
    @Json(name = "uri") var uri: String?,
    @Json(name = "url") var url: String?,
    @Json(name = "yield") var yield: Double?
)

data class Digest(
    @Json(name = "daily") var daily: Double?,
    @Json(name = "hasRDI") var hasRDI: Boolean,
    @Json(name = "label") var label: String?,
    @Json(name = "schemaOrgTag") val schemaOrgTag: String?,
    @Json(name = "sub") var sub: List<Sub>?,
    @Json(name = "tag") var tag: String?,
    @Json(name = "total") var total: Double?,
    @Json(name = "unit") var unit: String?
)

data class Ingredient(
    @Json(name = "food") var food: String?,
    @Json(name = "foodCategory") var foodCategory: String?,
    @Json(name = "foodId") var foodId: String?,
    @Json(name = "image") var image: String?,
    @Json(name = "measure") var measure: String?,
    @Json(name = "quantity") var quantity: Double?,
    @Json(name = "text") var text: String?,
    @Json(name = "weight") var weight: Double?
)

data class TotalDaily(
    @Json(name = "CA") var CA: CA?,
    @Json(name = "CHOCDF") var CHOCDF: CHOCDF?,
    @Json(name = "CHOLE") var CHOLE: CHOLE?,
    @Json(name = "ENERC_KCAL") var ENERC_KCAL: ENERCKCAL?,
    @Json(name = "FASAT") var FASAT: FASAT?,
    @Json(name = "FAT") var FAT: FAT?,
    @Json(name = "FE") var FE: FE?,
    @Json(name = "FIBTG") var FIBTG: FIBTG?,
    @Json(name = "FOLDFE") var FOLDFE: FOLDFE?,
    @Json(name = "K") var K: K?,
    @Json(name = "MG") var MG: MG?,
    @Json(name = "NA") var NA: NA?,
    @Json(name = "NIA") var NIA: NIA?,
    @Json(name = "P") var P: P?,
    @Json(name = "PROCNT") var PROCNT: PROCNT?,
    @Json(name = "RIBF") var RIBF: RIBF?,
    @Json(name = "THIA") var THIA: THIA?,
    @Json(name = "TOCPHA") var TOCPHA: TOCPHA?,
    @Json(name = "VITA_RAE") var VITA_RAE: VITARAE?,
    @Json(name = "VITB12") var VITB12: VITB12?,
    @Json(name = "VITB6A") var VITB6A: VITB6A?,
    @Json(name = "VITC") var VITC: VITC?,
    @Json(name = "VITD") var VITD: VITD?,
    @Json(name = "VITK1") var VITK1: VITK1?,
    @Json(name = "ZN") var ZN: ZN?
)

data class TotalNutrients(
    @Json(name = "CA") var CA: CA?,
    @Json(name = "CHOCDF") var CHOCDF: CHOCDF?,
    @Json(name = "CHOCDF.net") var CHOCDF_net: CHOCDFNet?,
    @Json(name = "CHOLE") var CHOLE: CHOLE?,
    @Json(name = "ENERC_KCAL") var ENERC_KCAL: ENERCKCAL?,
    @Json(name = "FAMS") var FAMS: FAMS?,
    @Json(name = "FAPU") var FAPU: FAPU?,
    @Json(name = "FASAT") var FASAT: FASAT?,
    @Json(name = "FAT") var FAT: FAT?,
    @Json(name = "FATRN") var FATRN: FATRN?,
    @Json(name = "FE") var FE: FE?,
    @Json(name = "FIBTG") var FIBTG: FIBTG?,
    @Json(name = "FOLAC") var FOLAC: FOLAC?,
    @Json(name = "FOLDFE") var FOLDFE: FOLDFE?,
    @Json(name = "FOLFD") var FOLFD: FOLFD?,
    @Json(name = "K") var K: K?,
    @Json(name = "MG") var MG: MG?,
    @Json(name = "NA") var NA: NA?,
    @Json(name = "NIA") var NIA: NIA?,
    @Json(name = "P") var P: P?,
    @Json(name = "PROCNT") var PROCNT: PROCNT?,
    @Json(name = "RIBF") var RIBF: RIBF?,
    @Json(name = "SUGAR") var SUGAR: SUGAR?,
    @Json(name = "SUGAR.added") var SUGAR_added: SUGARAdded?,
    @Json(name = "Sugar.alcohol") var Sugar_alcohol: SugarAlcohol?,
    @Json(name = "THIA") var THIA: THIA?,
    @Json(name = "TOCPHA") var TOCPHA: TOCPHA?,
    @Json(name = "VITA_RAE") var VITA_RAE: VITARAE?,
    @Json(name = "VITB12") var VITB12: VITB12?,
    @Json(name = "VITB6A") var VITB6A: VITB6A?,
    @Json(name = "VITC") var VITC: VITC?,
    @Json(name = "VITD") var VITD: VITD?,
    @Json(name = "VITK1") var VITK1: VITK1?,
    @Json(name = "WATER") var WATER: WATER?,
    @Json(name = "ZN") var ZN: ZN?
)

data class Sub(
    @Json(name = "daily") var daily: Double?,
    @Json(name = "hasRDI") var hasRDI: Boolean?,
    @Json(name = "label") var label: String?,
    @Json(name = "schemaOrgTag") var schemaOrgTag: String?,
    @Json(name = "tag") var tag: String?,
    @Json(name = "total") var total: Double?,
    @Json(name = "unit") var unit: String?
)

data class CA(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class CHOCDF(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class CHOLE(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class ENERCKCAL(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FASAT(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FAT(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FE(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FIBTG(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FOLDFE(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class K(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class MG(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class NA(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class NIA(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class P(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class PROCNT(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class RIBF(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class THIA(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class TOCPHA(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class VITARAE(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class VITB12(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class VITB6A(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class VITC(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class VITD(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class VITK1(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class ZN(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class CHOCDFNet(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FAMS(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FAPU(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FATRN(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FOLAC(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class FOLFD(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class SUGAR(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class SUGARAdded(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class SugarAlcohol(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)

data class WATER(
    @Json(name = "label") var label: String,
    @Json(name = "quantity") var quantity: Double,
    @Json(name = "unit") var unit: String
)