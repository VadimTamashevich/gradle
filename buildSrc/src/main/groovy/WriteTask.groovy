import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

@CacheableTask
class WriteTask extends DefaultTask {

    @InputFiles
    @PathSensitive(value = PathSensitivity.RELATIVE)
    final ConfigurableFileCollection inputFiles = project.objects.fileCollection()

    @OutputFile
    final RegularFileProperty outputFile = project.objects.fileProperty()

    @TaskAction
    void write() {
        inputFiles.asFileTree.each { File it ->
            outputFile.get().asFile.append("${it.name}\n")
        }
    }
}
