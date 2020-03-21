package comunda.example.datamatrix.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.DelegateVariableMapping
import org.camunda.bpm.engine.delegate.VariableScope
import org.camunda.bpm.engine.variable.VariableMap

class ProductToProductsMappingDelegate : DelegateVariableMapping {
    override fun mapOutputVariables(superExecution: DelegateExecution, subInstance: VariableScope) {
        // @TODO make it work :((
        superExecution.variables.clear()
        superExecution.variables.putAll(subInstance.variables)
    }

    override fun mapInputVariables(superExecution: DelegateExecution, subVariables: VariableMap) {
        subVariables.putAll(superExecution.variables)
    }
}
