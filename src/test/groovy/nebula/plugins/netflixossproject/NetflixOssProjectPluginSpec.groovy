package nebula.plugins.netflixossproject

import nebula.plugin.contacts.ContactsPlugin
import nebula.plugin.dependencylock.DependencyLockPlugin
import nebula.plugin.info.InfoPlugin
import nebula.plugin.publishing.NebulaJavadocJarPlugin
import nebula.plugin.publishing.NebulaPublishingPlugin
import nebula.plugin.publishing.NebulaSourceJarPlugin
import nebula.test.PluginProjectSpec
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPlugin

class NetflixOssProjectPluginSpec extends PluginProjectSpec {
    String pluginName = 'netflixoss-project'

    def 'plugin adds other plugins successfully to a simple project'() {
        when:
        project.plugins.apply(NetflixOssProjectPlugin)

        then:
        project.plugins.findPlugin(NebulaPublishingPlugin) != null
        project.plugins.findPlugin(NebulaJavadocJarPlugin) != null
        project.plugins.findPlugin(NebulaSourceJarPlugin) != null
        project.plugins.findPlugin(InfoPlugin) != null
        project.plugins.findPlugin(ContactsPlugin) != null
        project.plugins.findPlugin(DependencyLockPlugin) != null
    }

    def 'plugin sets default java version'() {
        project.plugins.apply(NetflixOssProjectPlugin)

        when:
        project.plugins.apply(JavaPlugin)

        then:
        project.sourceCompatibility == JavaVersion.VERSION_1_7
        project.targetCompatibility == JavaVersion.VERSION_1_7
    }

    def 'plugin allows changing java version'() {
        project.plugins.apply(NetflixOssProjectPlugin)
        project.plugins.apply(JavaPlugin)

        when:
        project.sourceCompatibility = '1.6'
        project.targetCompatibility = '1.6'

        then:
        project.sourceCompatibility == JavaVersion.VERSION_1_6
        project.targetCompatibility == JavaVersion.VERSION_1_6
    }


}
