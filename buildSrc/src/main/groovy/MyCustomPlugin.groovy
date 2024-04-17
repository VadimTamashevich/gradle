

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyCustomPlugin implements Plugin<Project> {

    String rejectedValueProp

    @Override
    void apply(Project project) {
        project.tasks.register("check-rejected-values", CheckImportTask) {
            group = 'custom'
            rejectedValue = rejectedValueProp
        }

        project.tasks.named("build") {
            it.dependsOn("check-rejected-values")
        }
    }
}