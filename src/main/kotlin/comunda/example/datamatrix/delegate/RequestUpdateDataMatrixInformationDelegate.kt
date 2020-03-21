package comunda.example.datamatrix.delegate

import comunda.example.datamatrix.messaging.listener.UpdateDataMatrixInformationListener
import comunda.example.datamatrix.model.DataMatrixInformationUpdatedMessage
import comunda.example.datamatrix.model.common.DataMatrixStatus
import comunda.example.datamatrix.model.common.Product
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class RequestUpdateDataMatrixInformationDelegate @Inject constructor(
    private val listener: UpdateDataMatrixInformationListener
) : JavaDelegate {
    override fun execute(execution: DelegateExecution) {
        val product = execution.getVariableLocal("product") as Product

        if (product.dataMatrix?.uit === null) {
            return
        }

        execution.setVariable(UpdateDataMatrixInformationListener.CORRELATION_UIT, product.dataMatrix!!.uit)

        listener.handleMessage(DataMatrixInformationUpdatedMessage(
            product.dataMatrix!!.uit,
            DataMatrixStatus.INTRODUCED
        ))
    }
}
