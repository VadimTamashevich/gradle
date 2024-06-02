import org.gradle.api.Plugin
import org.gradle.api.Project

class ReadWriteTaskPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def writeTask = project.tasks.register("write-task", WriteTask) {
            group = "custom"
            inputFiles.setFrom(project.tasks.named("compileJava").get().outputs.files)
            outputFile.set(project.layout.projectDirectory.file("result.txt"))
        }

        def readTask = project.tasks.register("read-task", ReadTask) {
            group = "custom"
            inputFile.set(writeTask.flatMap { it.outputFile })
        }
    }
}