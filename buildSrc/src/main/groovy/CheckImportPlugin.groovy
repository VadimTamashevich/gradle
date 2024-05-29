

import org.gradle.api.Plugin
import org.gradle.api.Project

class CheckImportPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.tasks.register("check-rejected-values", CheckImportTask) {
            group = 'custom'
            description = "check build source files with rejected value"
        }

        project.tasks.named("build") {
            it.dependsOn("check-rejected-values")
        }
    }
}