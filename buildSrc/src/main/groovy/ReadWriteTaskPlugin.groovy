import org.gradle.api.Plugin
import org.gradle.api.Project

class ReadWriteTaskPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.tasks.register("read-task", ReadTask) {
            group = "custom"
            inputFile = new File("./input.txt")
            dependsOn("build")
        }

        project.tasks.register("write-task", WriteTask) {
            group = "custom"
            input = new File("./input.txt")
            result = new File("./result.txt")
            dependsOn("read-task")
        }
    }
}
