package nebula.plugins.netflixossproject

import nebula.plugin.contacts.ContactsPlugin
import nebula.plugin.dependencylock.DependencyLockPlugin
import nebula.plugin.info.InfoPlugin
import nebula.plugin.publishing.NebulaJavadocJarPlugin
import nebula.plugin.publishing.NebulaPublishingPlugin
import nebula.plugin.publishing.NebulaSourceJarPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention

class NetflixOssProjectPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.plugins.apply(NebulaPublishingPlugin)
        project.plugins.apply(NebulaJavadocJarPlugin)
        project.plugins.apply(NebulaSourceJarPlugin)
        project.plugins.apply(InfoPlugin)
        project.plugins.apply(ContactsPlugin)
        project.plugins.apply(DependencyLockPlugin)

        project.plugins.withType(JavaPlugin) { JavaPlugin javaPlugin ->
            JavaPluginConvention convention = project.convention.getPlugin(JavaPluginConvention)
            convention.sourceCompatibility = JavaVersion.VERSION_1_6
            convention.targetCompatibility = JavaVersion.VERSION_1_6
        }
    }
}
