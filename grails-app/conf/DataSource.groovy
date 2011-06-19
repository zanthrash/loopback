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
//            driverClassName = "com.mysql.jdbc.Driver"
//            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
//			schema = 'loopback'
//			url= "jdbc:mysql://localhost/${schema}"
//            dbCreate = "create-drop"
//            username = "loopback"
//            password = "loopback"
//            loggingSql = false


            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
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
