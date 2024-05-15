


import org.gradle.api.BuildCancelledException
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class CheckImportTask extends DefaultTask {

    @Input
    String rejectedValue

    @TaskAction
    void task() {
        project.fileTree("./").files.each { it ->
            if (it.text.contains(rejectedValue) && it.name != "build.gradle") {
                throw new BuildCancelledException("build was cancelled because project " +
                        "$project.name contains rejected value $rejectedValue in file ${it.name}")
            }
        }
    }
}
