import org.gradle.api.Plugin
import org.gradle.api.Project

class ReadWriteTaskPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.tasks.register("read-task", ReadTask) {
            group = "custom"
            file = project.projectDir.createNewFile "./outputs/result.txt"
        }

        project.tasks.register("write-task", WriteTask) {
            group = "custom"
            file = file.fileValue(new File("./outputs/result.txt"))
        }
    }
}
