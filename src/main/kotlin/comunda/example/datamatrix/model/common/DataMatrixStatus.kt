package comunda.example.datamatrix.model.common

import java.io.Serializable

enum class DataMatrixStatus: Serializable {
    EMITTED,
    INTRODUCED,
    RETIRED
}
