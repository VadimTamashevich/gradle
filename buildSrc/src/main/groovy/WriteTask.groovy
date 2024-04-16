import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class WriteTask extends DefaultTask{

    @OutputFile
    RegularFileProperty file

    @TaskAction
    void write() {
        File file = file.get().asFile
        project.rootDir.listFiles().each {
            file.append("${it.name}\n")
        }
    }
}
