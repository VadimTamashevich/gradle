import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

class ReadTask extends DefaultTask{

    @InputFile
    RegularFileProperty file

    @TaskAction
    void printTask() {
        println(file.get().asFile.text)
    }
}
