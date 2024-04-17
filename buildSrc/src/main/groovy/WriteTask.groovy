import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

@CacheableTask
class WriteTask extends DefaultTask {

    @OutputFile
    final RegularFileProperty outputFile = project.objects.fileProperty()

    @TaskAction
    void write() {
        project.layout.projectDirectory.asFileTree.each { File it ->
            outputFile.get().asFile.append("${it.name}\n")
        }
    }
}
