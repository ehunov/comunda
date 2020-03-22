package comunda.example.datamatrix.messaging.listener

import comunda.example.datamatrix.model.DataMatrixInformationUpdatedMessage
import comunda.example.datamatrix.model.common.DataMatrix
import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class UpdateDataMatrixInformationListener @Inject constructor(
    private val runtimeService: RuntimeService
) {
    fun handleMessage(message: DataMatrixInformationUpdatedMessage) {
        runtimeService.createMessageCorrelation(MESSAGE_NAME)
            .setVariable("dataMatrix", DataMatrix(message.uit, message.status))
            .processInstanceVariableEquals(CORRELATION_VARIABLE_UIT, message.uit)
            .correlateAllWithResult()
    }

    companion object {
        const val MESSAGE_NAME = "DataMatrixInformationUpdated"
        const val CORRELATION_VARIABLE_UIT = "uit"
    }
}
