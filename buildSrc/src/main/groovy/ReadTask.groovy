import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.SkipWhenEmpty
import org.gradle.api.tasks.TaskAction

class ReadTask extends DefaultTask {

    @InputFile
    @SkipWhenEmpty
    final RegularFileProperty inputFile = project.objects.fileProperty()

    @TaskAction
    void printTask() {
        println(inputFile.get().asFile.text)
    }
}
