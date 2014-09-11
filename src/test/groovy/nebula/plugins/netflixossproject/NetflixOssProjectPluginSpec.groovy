package nebula.plugins.netflixossproject

import nebula.test.PluginProjectSpec

class NetflixOssProjectPluginSpec extends PluginProjectSpec {
    String pluginName = 'netflixOssProject'

    def 'plugin adds other plugins successfully'() {
        when:
        def x = 1 + 1

        then:
        x == 2
    }
}
