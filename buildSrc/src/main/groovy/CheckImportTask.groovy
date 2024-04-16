import org.gradle.api.BuildCancelledException
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class CheckImportTask extends DefaultTask {

    @Input
    String rejectedValue

    @TaskAction
    void task() {
        project.rootDir.listFiles().each { it ->
            if (it.text.contains(rejectedValue)) {
                throw new BuildCancelledException("build was cancelled because project " +
                        "$project.name contains rejected value $rejectedValue in file ${it.name}")
            }
        }
    }
}
