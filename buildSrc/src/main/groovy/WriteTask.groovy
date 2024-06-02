import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.*
import org.gradle.work.Incremental

@CacheableTask
class WriteTask extends DefaultTask {

    @InputFiles
    @Incremental
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
