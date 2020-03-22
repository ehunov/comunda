package comunda.example.datamatrix.model.common

import java.io.Serializable

enum class DocumentStatus: Serializable {
    CREATED,
    WAITING,
    FAILED,
    PARTIALED,
    FINISHED
}
