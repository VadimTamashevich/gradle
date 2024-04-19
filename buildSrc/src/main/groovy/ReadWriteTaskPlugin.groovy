import org.gradle.api.Plugin
import org.gradle.api.Project

class ReadWriteTaskPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def writeTask = project.tasks.register("write-task", WriteTask) {
            group = "custom"
            outputFile.set(project.layout.projectDirectory.file("result.txt"))
            enabled = false
        }

        def readTask = project.tasks.register("read-task", ReadTask) {
            group = "custom"
            inputFile.set(writeTask.get().outputFile)
        }

        readTask.configure {onlyIf {writeTask.get().didWork}}
    }
}
