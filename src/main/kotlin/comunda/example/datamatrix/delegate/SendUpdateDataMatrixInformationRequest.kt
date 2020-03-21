package comunda.example.datamatrix.delegate

import comunda.example.datamatrix.model.common.Product
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

class SendUpdateDataMatrixInformationRequest: JavaDelegate {
    override fun execute(execution: DelegateExecution) {
        val product = execution.getVariableLocal("product") as Product


    }
}
