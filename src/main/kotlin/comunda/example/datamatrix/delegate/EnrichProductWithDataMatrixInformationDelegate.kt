package comunda.example.datamatrix.delegate

import comunda.example.datamatrix.model.ShipmentDocumentRequest
import comunda.example.datamatrix.model.common.DataMatrix
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

class EnrichProductWithDataMatrixInformationDelegate: JavaDelegate {
    override fun execute(execution: DelegateExecution) {
        val request = execution.getVariableLocal("shipmentDocumentRequest") as ShipmentDocumentRequest
        val dataMatrix = execution.getVariableLocal("dataMatrix") as DataMatrix

        val product = request.products.find { it.dataMatrix?.uit == dataMatrix.uit }

        if (product != null) {
            product.dataMatrix = dataMatrix
        }
    }
}
