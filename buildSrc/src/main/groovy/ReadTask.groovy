import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

class ReadTask extends DefaultTask{

    @InputFile
    File inputFile

    @TaskAction
    void printTask() {
        println(inputFile.text.split(","))
    }
}
