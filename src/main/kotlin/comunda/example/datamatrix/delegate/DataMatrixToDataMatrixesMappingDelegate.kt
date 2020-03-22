package comunda.example.datamatrix.delegate

import comunda.example.datamatrix.model.common.DataMatrix
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.DelegateVariableMapping
import org.camunda.bpm.engine.delegate.VariableScope
import org.camunda.bpm.engine.variable.VariableMap

class DataMatrixToDataMatrixesMappingDelegate : DelegateVariableMapping {
    override fun mapOutputVariables(superExecution: DelegateExecution, subInstance: VariableScope) {
        val dataMatrixes = if (superExecution.getVariable("dataMatrixes") == null) {
            arrayListOf<DataMatrix>()
        } else {
            superExecution.getVariable("dataMatrixes") as ArrayList<DataMatrix>
        }

        dataMatrixes.add(subInstance.getVariable("dataMatrix") as DataMatrix)

        superExecution.setVariable("dataMatrixes", dataMatrixes)
    }

    override fun mapInputVariables(superExecution: DelegateExecution, subVariables: VariableMap) {
        subVariables.putAll(superExecution.variables)
    }
}
