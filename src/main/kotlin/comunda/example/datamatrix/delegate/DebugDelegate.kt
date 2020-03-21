package comunda.example.datamatrix.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

class DebugDelegate : JavaDelegate {
    override fun execute(execution: DelegateExecution) {
        val variables = execution.variables;
        val localVariables = execution.variablesLocal

        val variableNames = execution.variableNames
    }
}
