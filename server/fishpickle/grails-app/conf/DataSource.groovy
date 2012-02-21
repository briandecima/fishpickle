dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = "grails"
	password = "server"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
	development {
		dataSource {
			// one of 'create', 'create-drop','update'
			dbCreate = "create-drop"
			url = "jdbc:mysql://localhost:3306/fishpickle?autoreconnect=true"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/fishpickle?autoreconnect=true"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/fishpickle?autoreconnect=true"
		}
	}
}
