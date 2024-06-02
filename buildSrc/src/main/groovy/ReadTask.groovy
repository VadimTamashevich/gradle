import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.work.Incremental

class ReadTask extends DefaultTask {

    @InputFile
    @Incremental
    @PathSensitive(value = PathSensitivity.RELATIVE)
    final RegularFileProperty inputFile = project.objects.fileProperty()

    @TaskAction
    void printTask() {
        println(inputFile.get().asFile.text)
    }
}
