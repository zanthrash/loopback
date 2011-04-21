dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
//            driverClassName = "com.p6spy.engine.spy.P6SpyDriver" // use this driver to enable p6spy logging
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			schema = 'loopback'
			url= "jdbc:mysql://localhost/${schema}"
            dbCreate = "create-drop"
            username = "loopback"
            password = "loopback"
            loggingSql = false
        }

    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:file:prodDb;shutdown=true"
        }
    }
}
