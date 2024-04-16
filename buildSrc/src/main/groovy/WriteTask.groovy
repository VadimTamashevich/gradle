import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class WriteTask extends DefaultTask{

    @InputFile
    File input

    @OutputFile
    File result

    @TaskAction
    void write() {
        project.rootDir.listFiles().each {
            result.append("${it.name}, ")
        }
    }
}
